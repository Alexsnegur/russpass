document.addEventListener('DOMContentLoaded', () => {
  // const button_wrapLilcJ = document.querySelectorAll('.button_wrap__lilcJ')

	// setTimeout(() => {
	// 	console.log(button_wrapLilcJ);
	// }, 1000)

	// button_wrapLilcJ[1].addEventListener('click', () => {
	// 	const catalogNotaFiltersFgBSg = document.querySelector('.catalogNota_filters__fgBSg')
	// 	const filter = catalogNotaFiltersFgBSg.childNodes[1]

	// 	filter.style.position = 'relative'
	// 	filter.style.top = '0'

	// 	const catalogNotaScrolledId = document.querySelector('.catalogNota_scrolled__7ggaI')
	// 	catalogNotaScrolledId.classList.add('catalogNota_showFilters__mZJl4')
	// })

	// const housingFiltersNota_close = document.querySelector('.housingFiltersNota_close')
	// housingFiltersNota_close.addEventListener('click', () => {
	// 	const catalogNotaFiltersFgBSg = document.querySelector('.catalogNota_filters__fgBSg')
	// 	const filter = catalogNotaFiltersFgBSg.childNodes[1]

	// 	filter.style.position = 'sticky'
	// 	filter.style.top = '75px'

	// 	const catalogNotaScrolledId = document.querySelector('.catalogNota_scrolled__7ggaI')
	// 	catalogNotaScrolledId.classList.remove('catalogNota_showFilters__mZJl4')
	// })

	// // form
	// const petsForm = document.querySelector('.pets__form')
	// petsForm.addEventListener('submit', submitQuestionPets)

	// function submitQuestionPets(e) {
	// 	e.preventDefault()
	// 	e.stopPropagation()

	// 	const petsWrapper = document.querySelector('.pets__wrapper')
	// 	const petsInput = document.querySelector('.pets__input')
	// 	const pets__dialog = document.querySelector('.pets__dialog')
		
	// 	const petsQuestionElem = document.createElement('div')
	// 	const petsMessageElem = document.createElement('div')
		
	// 	const petsQuestionContainer = document.createElement('div')
	// 	const petsMessageContainer = document.createElement('div')


	// 	petsQuestionContainer.classList.add('pets__question')
	// 	petsQuestionElem.classList.add('pets__question-elem')
	// 	petsMessageContainer.classList.add('pets__message')
	// 	petsMessageElem.classList.add('pets__message-elem')

	// 	petsQuestionElem.innerHTML = petsInput.value
	// 	petsMessageElem.innerHTML = (Math.random(0, 100) * 100).toFixed(2)



	// 	if(petsInput.value) {
	// 		petsMessageContainer.append(petsMessageElem)
	// 		petsQuestionContainer.append(petsQuestionElem)
	// 		petsWrapper.append(petsQuestionContainer, petsMessageContainer)

	// 		pets__dialog.scrollTop = petsWrapper.scrollHeight

	// 		petsInput.value = ''
	// 	}

	// 	console.log(petsWrapper.scrollHeight);

	// 	// petsWrapper.style.transform = `translateY(100%)`
	// }

	// const petsDialog = document.querySelector('.pets__dialog')

	// petsDialog.addEventListener('mousemove', (e) => {
	// 	e.stopPropagation()
	// })
	getBD()
	async function getBD() {
		const response = await fetch('http://192.168.0.34:8181/hotel')
		const result = await response.json()

	// Item Hotel
	const catalogNota_items__5aFjU = document.querySelector('.catalogNota_items__5aFjU')
	for(let i = 0; i < result.length; i++) {
		const containerItem = document.createElement('div')
		const photoWrapper = document.createElement('div')
		const body = document.createElement('div')

		const img = document.createElement('img')

		img.src = '../' + result[i].photo

		console.log(result[i].photo);
		
		const bodyTitle = document.createElement('a')
		const bodyDesc = document.createElement('div')
		const bodyFooter = document.createElement('div')

		bodyTitle.href = './item-hotel/hotel.html'

		const wrapperPath = document.createElement('div')
		const wrapperFood = document.createElement('div')

		const bodyDescCity = document.createElement('div')
		const bodyDescHotel = document.createElement('div')
		const bodyDescPath = document.createElement('div')

		const btn = document.createElement('button')

		img.classList.add('catalog-item__body-img')
		containerItem.classList.add('catalogNota_item__mvFJo')
		photoWrapper.classList.add('catalog-item__photo')
		body.classList.add('catalog-item__body')
		bodyTitle.classList.add('catalog-item__body-title')
		bodyDesc.classList.add('catalog-item__body-desc')
		wrapperPath.classList.add('catalog-item__wrapper-desc-path')
		bodyDescCity.classList.add('catalog-item__desc-path')
		bodyDescHotel.classList.add('catalog-item__desc-path')
		bodyDescPath.classList.add('catalog-item__desc-path')
		wrapperFood.classList.add('catalog-item__desc-path')
		btn.classList.add('catalog-item__footer-btn')

		bodyTitle.innerHTML = result[i].name

		bodyDescCity.innerHTML = result[i].city
		bodyDescHotel.innerHTML = result[i].address
		bodyDescPath.innerHTML = result[i].description
		if(result[i].restaurant)
			wrapperFood.innerHTML = 'Питание включено'
		btn.innerHTML = result[i].roomPrice

		bodyTitle.addEventListener('click', () => {
			localStorage.setItem('id', result[i].id)
		})

		photoWrapper.append(img)
		wrapperPath.append(bodyDescCity, bodyDescHotel, bodyDescPath)
		bodyDesc.append(wrapperPath, wrapperFood)
		bodyFooter.append(btn)
		body.append(bodyTitle, bodyDesc, bodyFooter)
		containerItem.append(photoWrapper, body)
		catalogNota_items__5aFjU.append(containerItem)
	}

		console.log(787878);

		console.log(result);
	}
})
