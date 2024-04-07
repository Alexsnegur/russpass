function giveXp() {
	console.log("XP Issued")
	fetch("http://192.168.0.34:8181/level/xp", {
		method: "PUT",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			userId: 1,
			amount: 300
		})

	})
}

document.addEventListener('DOMContentLoaded', () => {
	const previewCard_wrap__GdZvG = document.querySelectorAll('.previewCard_wrap__GdZvG')
	const placeRightContainer = document.querySelector('.place-right-container')

	const smallCat = document.getElementById('small-icon-cat')

	const mainInputCat = document.querySelector('.main-input-cat')
	const formCatInput = document.querySelector('.form-cat-input')

	previewCard_wrap__GdZvG.forEach(elem => {
		elem.addEventListener('click', async () => {
			giveXp()
			placeRightContainer.classList.add('place-right-container-active')

			const loaderContainer = document.querySelector('.loader-container')
			loaderContainer.classList.add('loader-container-active')

			const dialogCatText = document.querySelector('.dialog-cat-text')

			smallCat.classList.add('small-icon-cat-hide')

			const formData = new FormData(elem)

			formData.append('data', JSON.stringify(elem.dataset.name))
			// if(localStorage.getItem('name')) {
			// 	formData.append('username', JSON.stringify(elem.dataset.name))
			// } else {
			// 	formData.append('username', 'бот')
			// }

			console.log(elem.dataset.name);

			// 192.168.0.34:8003
			const response = await fetch('http://192.168.0.34:8003/descript_place', {
				method: 'POST',
				body: formData
			})

			if(response.ok) {
				const result = await response.json()

				dialogCatText.innerHTML = result.message

				loaderContainer.classList.remove('loader-container-active')
			}

			formCatInput.classList.remove('form-cat-input-no-active')

			catSummon()
		})
	})

	// const headerButtonNota_title__8UJQM = document.querySelector('.headerButtonNota_title__8UJQM div')
	// console.log(headerButtonNota_title__8UJQM);
	// const sign = headerButtonNota_title__8UJQM.querySelectorAll('.headerButtonNota_title__8UJQM div')
	// sign.forEach((elem, i) => {
	// 	if(i === 4) {
	// 		sign[i].innerHTML = 'Выйти'
	// 	}
	// })
	// headerButtonNota_title__8UJQM.innerHTML = 'Выйти'

	if(localStorage.getItem('goGroup') === 'true') {
		// localStorage.setItem('goGroup', 'false')

		const dialogCatText = document.querySelector('.dialog-cat-text')
		const dialogGroup = document.createElement('div')
		const wrapperwrapper = document.createElement('div')
		const wrapperBtnGroup = document.createElement('div')
		const groupGo = document.createElement('button')
		const groupStop = document.createElement('button')

		dialogCatText.innerHTML = ''

		wrapperwrapper.classList.add('wrapperwrapper')
		wrapperBtnGroup.classList.add('wrapperChatNewSobes')
		groupGo.classList.add('wrapperChatNewSobes-go')
		groupStop.classList.add('wrapperChatNewSobes-stop')
		dialogGroup.classList.add('wrapperChatNewSobes-dialog')

		dialogGroup.innerHTML = 'Мы можем подобрать Вам компанию в путешествие! Для этого мы Вас объединим в беседу, где вы сможете вместе спланировать дальнейшее путешествие'
		groupGo.innerHTML = 'Хочу!'
		groupStop.innerHTML = 'Нет'

		groupGo.addEventListener('click', () => {
			console.log('урра');
			dialogCatText.innerHTML = 'Скоро мы найдем Вам группу'
		})

		groupStop.addEventListener('click', () => {
			dialogCatText.innerHTML = 'Жаль :('
			
			// catDismiss()
		})

		wrapperBtnGroup.append(groupGo, groupStop)
		wrapperwrapper.append(dialogGroup, wrapperBtnGroup)
		dialogCatText.append(wrapperwrapper)
	}

	// if(localStorage.getItem('activeCat') === 'true') {
	// 	smallCat.classList.add('small-icon-cat-hide')
		
	// 	const formCatInput = document.querySelector('.form-cat-input')
	// 	formCatInput.classList.remove('form-cat-input-no-active')

	// 	catSummon()
	// }

	smallCat.addEventListener('click', () => {
		smallCat.classList.add('small-icon-cat-hide')

		localStorage.setItem('activeCat', 'true')

		const formCatInput = document.querySelector('.form-cat-input')
		formCatInput.classList.remove('form-cat-input-no-active')

		catSummon()
	})

	placeRightContainer.addEventListener('click', () => {
		placeRightContainer.classList.remove('place-right-container-active')

		formCatInput.classList.add('form-cat-input-no-active')

		setTimeout(() => {
			smallCat.classList.remove('small-icon-cat-hide')
		}, 400)

		catDismiss()
	})

	catDismiss()
	formCatInput.classList.add('form-cat-input-no-active')

	mainInputCat.addEventListener('input', () => {
		console.log('skjskj');
	})

	const exit = document.querySelector('.exit')
	if(localStorage.getItem('name')) {
		exit.innerHTML = localStorage.getItem('name')
	} else {
		exit.innerHTML = 'Войти'
	}

	formCatInput.addEventListener('submit', submitForm)
	async function submitForm(e) {
		e.preventDefault();

		playAnimationConfuse()

		const loaderContainer = document.querySelector('.loader-container')
		loaderContainer.classList.add('loader-container-active')

		const dialogCatText = document.querySelector('.dialog-cat-text')
		dialogCatText.innerHTML = ''

		const formData = new FormData(formCatInput)
		formData.append('data', JSON.stringify(mainInputCat.value))

		const response = await fetch('http://192.168.0.34:8003/answering', {
			method: 'POST',
			body: formData
		})

		if(response.ok) {
			loaderContainer.classList.remove('loader-container-active')
			const result = await response.json()

			dialogCatText.innerHTML = result.message

			formCatInput.classList.remove('form-cat-input-no-active')

			catSummon()

			mainInputCat.value = ''
		} else {
			alert('error')
		}
	}
})
