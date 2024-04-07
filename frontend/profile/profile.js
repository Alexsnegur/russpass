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
		.then(levelResponse => {
			level.textContent = levelResponse;
			document.getElementById("level-big").textContent = levelResponse;
		});
	
	const barWidth = (xp.textContent / 10);
	const bar = document.getElementById("bar");
	bar.style.width = barWidth + "%";
})

function equipHat() {
	console.log("Equipped")
	document.getElementById("hat-image").classList.remove("d-none");
}