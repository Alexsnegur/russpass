document.addEventListener('DOMContentLoaded', () => {
  async function getHotelItem() {
    const id = localStorage.getItem('id')
    console.log(id);

    const response = await fetch(`http://192.168.0.34:8181/hotel/${id}`)
    const result = response.json()

    console.log(result);

    const itemHeaderWrapperPhotoImg = document.querySelector('.item__header-wrapper-photo-img')

    result.then((res, req) => {
      console.log(res, req);
      itemHeaderWrapperPhotoImg.src = '../../' + res.photo
    })
  }

  const itemItemWrapperStickyVbborWrapperPriceBtn = document.querySelector('.item__item-wrapper-sticky-vbbor-wrapper-price-btn')

  itemItemWrapperStickyVbborWrapperPriceBtn.addEventListener('click', () => {
    console.log();
    const headerLinks_logo__PVbof = document.querySelector('.headerLinks_logo__PVbof')


    const fakeLoad = document.querySelector('.fake-load')
    fakeLoad.classList.add('fake-load-active')

    setTimeout(() => {
      fakeLoad.classList.remove('fake-load-active')
      headerLinks_logo__PVbof.click()
    }, 3000)
  })

  getHotelItem()

  if(localStorage.getItem('activeCat') === 'true') {
		const smallIconCat = document.getElementById('small-icon-cat')
		smallIconCat.click()
	} else {
		const smallIconCat = document.querySelector('.close-cat')
		smallIconCat.click()
	}
})
