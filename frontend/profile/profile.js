document.addEventListener('DOMContentLoaded', () => {
  if(localStorage.getItem('activeCat') === 'true') {
		const smallIconCat = document.getElementById('small-icon-cat')
		smallIconCat.click()
	} else {
		const smallIconCat = document.querySelector('.close-cat')
		smallIconCat.click()
	}

  const exit = document.querySelector('.exit')
	if(localStorage.getItem('name')) {
		exit.innerHTML = localStorage.getItem('name')
	} else {
		exit.innerHTML = 'Войти'
	}

  // command - 1) 'dark'
           //  2) 'light'
           //  3) 'complete'
  function changeTheme(number, command) {
    const rollPresentItem = document.querySelectorAll('.roll-present-item')
    rollPresentItem.forEach((elem, i) => {
      console.log(elem);
      if(i + 1 === number) {
        if(command === 'dark') {
          console.log(elem.childNodes[3].childNodes[1].childNodes[3]);
          elem.childNodes[3].childNodes[1].childNodes[3].classList.add('display-none')
          elem.childNodes[3].childNodes[1].childNodes[5].classList.add('display-none')
          elem.childNodes[3].childNodes[1].classList.add('roll-present-item-active')
        } else if(command === 'light') {
          elem.childNodes[3].childNodes[1].childNodes[3].classList.add('display-none')
          elem.childNodes[3].childNodes[1].childNodes[5].classList.remove('display-none')
          elem.childNodes[3].childNodes[1].classList.remove('roll-present-item-active')
        } else if(command === 'complete') {
          elem.childNodes[3].childNodes[1].childNodes[3].classList.remove('display-none')
          elem.childNodes[3].childNodes[1].childNodes[5].classList.add('display-none')
          elem.childNodes[3].childNodes[1].classList.remove('roll-present-item-active')
        }
      }
    })
  }

	const xp = document.getElementById("xp");
	fetch("http://localhost:8181/level/xp/1")
		.then(response => response.json())
		.then(xpResponse => {
      fillBar(xpResponse)
      xp.textContent = xpResponse
    }
    );

	const level = document.getElementById("level");
	fetch("http://localhost:8181/level/1")
		.then(response => response.json())
		.then(levelResponse => {
			level.textContent = levelResponse;
			document.getElementById("level-big").textContent = levelResponse;

        let i = 0;
        for (; i < level.textContent; i++) {
            changeTheme(i + 1, "complete");
        }

        for (; i < 8; i++) {
            changeTheme(i + 1, "dark");
        }
	});
})

function fillBar(xp) {
  const barWidth = (xp / 10);
	const bar = document.getElementById("bar");
	bar.style.width = barWidth + "%";
}

function equipHat() {
	console.log("Equipped")
	document.getElementById("hat-image").classList.remove("d-none");
}

function giftDiscount() {
  alert("Подарок: скидка 5%")
}

function giftHat() {
  alert("Подарок: новая шляпа");
  fetch("http://localhost:8181/reward", {
    method: "PUT",
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      userId: 1,
      rewardId: 1
    })
  })
}