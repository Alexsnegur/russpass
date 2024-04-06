document.addEventListener('DOMContentLoaded', () => {
	const previewCard_wrap__GdZvG = document.querySelectorAll('.previewCard_wrap__GdZvG')
	const placeRightContainer = document.querySelector('.place-right-container')

	const mainInputCat = document.querySelector('.main-input-cat')
	const formCatInput = document.querySelector('.form-cat-input')

	previewCard_wrap__GdZvG.forEach(elem => {
		elem.addEventListener('click', () => {
			console.log('dldk');
			placeRightContainer.classList.add('place-right-container')

			formCatInput.classList.remove('form-cat-input-no-active')

			catSummon()
		})
	})

	placeRightContainer.addEventListener('click', () => {
		placeRightContainer.classList.remove('place-right-container')

		formCatInput.classList.add('form-cat-input-no-active')

		catDismiss()
	})

	mainInputCat.addEventListener('input', () => {
		console.log('skjskj');
	})

	formCatInput.addEventListener('submit', submitForm)
	async function submitForm(e) {
		e.preventDefault();

		const loaderContainer = document.querySelector('.loader-container')
		loaderContainer.classList.add('loader-container-active')

		const dialogCatText = document.querySelector('.dialog-cat-text')
		dialogCatText.innerHTML = ''

		const formData = new FormData(formCatInput)
		formData.append('data', JSON.stringify(mainInputCat.value))

		const response = await fetch('http://192.168.0.34:80/answering', {
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

		console.log(result);
	}
})