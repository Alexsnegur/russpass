document.addEventListener('DOMContentLoaded', () => {
  if(localStorage.getItem('activeCat') === 'true') {
		const smallIconCat = document.getElementById('small-icon-cat')
		smallIconCat.click()
	} else {
		const smallIconCat = document.querySelector('.close-cat')
		smallIconCat.click()
	}

	const xp = document.getElementById("xp");
	fetch("http://localhost:8181/level/xp/1")
		.then(response => response.json())
		.then(xpResponse => xp.textContent = xpResponse);

	const level = document.getElementById("level");
	fetch("http://localhost:8181/level/1")
		.then(response => response.json())
		.then(levelResponse => level.textContent = levelResponse);

	for (let i = 1; i <= level; ++i) {
		const present = document.getElementById("present-" + i);		
		present.classList.add("available");
	}
})
