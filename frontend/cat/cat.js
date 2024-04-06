const animationJump = "jump";
const animationIdle = "idle";
const animationHidden = "hidden";

const petTimesThreashold = 3;

const hatPath = "hat";

const jumpDurationSeconds = 0.5;

const catContainer = document.getElementById("cat-container");
const cat = document.getElementById("cat");
const catHat = document.getElementById("cat-hat");

let petCounter = 0;

playAnimationIdle();

function catSummon() {
  faceRight();
  playAnimationJump();
  unhide();

  setTimeout(() => {
    playAnimationIdle();
    const borderSvg = document.querySelector('.border-svg')
    const dialogCatText = document.querySelector('.dialog-cat-text')

    borderSvg.classList.add('border-svg-active')
    dialogCatText.classList.add('dialog-cat-text-active')
  }, 1000 * jumpDurationSeconds);
}

function catDismiss() {
  petCounter = 0;

  faceLeft();
  playAnimationJump();
  hide();

  console.log('hide');
}

function faceRight() {
  catContainer.classList.add("mirror");
}

function faceLeft() {
  setTimeout(() => {
    catContainer.classList.remove("mirror");
  }, 300)
}

function hide() {
  const borderSvg = document.querySelector('.border-svg')
  const dialogCatText = document.querySelector('.dialog-cat-text')

  borderSvg.classList.remove('border-svg-active')
  dialogCatText.classList.remove('dialog-cat-text-active')

  setTimeout(() => {
    catContainer.classList.add("hidden");
  }, 300)
}

function unhide() {
  catContainer.classList.remove("hidden");
}

function getHatAnimationIdle(hatPath) {
  if (hatPath === "") {
    return "";
  }

  return '../cat-view/' + hatPath + "_idle.webp";
}

function getHatAnimationJump() {
  if (hatPath === "") {
    return "";
  }

  return '../cat-view/' + hatPath + "_jump.webp";
}

function playAnimationIdle() {
  cat.src = "../cat-view/cat_idle.webp";
  catHat.src = getHatAnimationIdle(hatPath);
}

function playAnimationJump() {
  cat.src = "../cat-view/cat_jump.webp";

  setTimeout(() => {
    catHat.src = getHatAnimationJump(hatPath);
  }, 300)
}

function playAnimationConfuse() {
  cat.src = "../cat-view/cat_confuse.webp";
  catHat.src = "";
  catHat.src = getHatAnimationIdle(hatPath);
}

function playAnimationHappy() {
  cat.src = "../cat-view/cat_happy.webp";
  catHat.src = "";
  catHat.src = getHatAnimationIdle(hatPath);
}

catContainer.addEventListener('click', function(e) {
  petCounter++;
  if (petCounter == petTimesThreashold) {
    playAnimationHappy()
  }

  console.log('click on ', e );

  const x = e.pageX - 15
  const y = e.pageY - 15

  const heart = document.createElement('div');
  heart.classList.add("heart");
  heart.style.left = x + "px";
  heart.style.top = y + "px";
  document.body.appendChild(heart);
  setTimeout(() => {
    heart.style.top = 0;
    heart.style.opacity = 0;
  }, 10);

  setTimeout(() => {
    heart.remove()
  }, 750)
})
