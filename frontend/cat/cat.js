const animationJump = "jump";
const animationIdle = "idle";
const animationHidden = "hidden";

const petTimesThreashold = 3;

let hatPath = null;
fetch("http://192.168.0.34:8181/hat/1")
  .then(response => response.json())
  .then(result => {
    console.log("Hat path = " + result.imagePath)
    hatPath = result.imagePath
  })

const jumpDurationSeconds = 0.5;



const catContainer = document.getElementById("cat-container");
const cat = document.getElementById("cat");
const smallCat = document.getElementById("small-cat");
const catHat = document.getElementById("cat-hat");
const formCatInput = document.querySelector('.form-cat-input')

const closeCat = document.querySelector('.close-cat')

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
  if (hatPath == null) {
    return "";
  }

  return '../cat-view/' + hatPath + "_idle.webp";
}

function getHatAnimationJump() {
  if (hatPath == null) {
    return "";
  }

  return '../cat-view/' + hatPath + "_jump.webp";
}

function playAnimationIdle() {
  cat.src = "../cat-view/cat_idle.webp";
  smallCat.src = '../cat-view/cat_idle.webp'
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

closeCat.addEventListener('click', (e) => {
  e.stopPropagation()
  const smallIconCat = document.getElementById('small-icon-cat')

  const formCatInput = document.querySelector('.form-cat-input')
  formCatInput.classList.add('form-cat-input-no-active')

  localStorage.setItem('activeCat', 'false')

  console.log(1);

  setTimeout(() => {
    smallIconCat.classList.remove('small-icon-cat-hide')
  }, 400)

  catDismiss()
})
