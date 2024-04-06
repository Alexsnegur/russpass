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

  getHotelItem()
})
