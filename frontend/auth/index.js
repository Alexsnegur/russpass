document.addEventListener('DOMContentLoaded', () => {
  const authForm = document.querySelector('.auth-form')
  const authSubmitNew = document.querySelector('.auth-submit-new')
  const headerLinks_logo__PVbof = document.querySelector('.headerLinks_logo__PVbof')

  // authForm.addEventListener('submit', async (e) => {
  //   e.preventDefault()

  //   const authInputLogin = document.querySelector('.auth-input-login')
  //   const authInputPassword = document.querySelector('.auth-input-password')

  //   const formData = new FormData(authForm)

  //   formData.append('login', JSON.stringify(authInputLogin.value))
  //   formData.append('pass', JSON.stringify(authInputPassword.value))

  //   const response = await fetch('http://192.168.0.34:8181/user', {
  //     method: 'POST',
  //     body: formData
  //   })

  //   if(response.ok) {
  //     const result = await response.json()

  //     if(result.username === authInputLogin.value && result.password === authInputPassword.value) {
  //       localStorage.setItem('idUser', result.id)
  //       localStorage.setItem('score', result.score)

  //       headerLinks_logo__PVbof.click()
  //     }

  //     console.log(result);
  //   }
  // })

  authForm.addEventListener('submit', async (e) => {
    e.preventDefault()

    const authInputLogin = document.querySelector('.auth-input-login')
    const authInputPassword = document.querySelector('.auth-input-password')

    const formData = new FormData(authForm)

    formData.append('login', JSON.stringify(authInputLogin.value))
    formData.append('pass', JSON.stringify(authInputPassword.value))

    localStorage.setItem('name', authInputLogin.value)

    const response = await fetch('http://192.168.0.34:8181/user', {
      method: 'POST',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
      body: JSON.stringify({
        'login': JSON.stringify(authInputLogin.value),
        'password': JSON.stringify(authInputPassword.value)
      })
    })

    if(response.ok) {
      const result = await response.json()
      
      localStorage.setItem('idUser', result.id)
      localStorage.setItem('score', result.score)

      authInputLogin.value = ''
      authInputPassword.value = ''

      headerLinks_logo__PVbof.click()

      console.log(result);
    } else {
      alert('error')
    }
  })

  async function tt() {
    const response = await fetch('http://192.168.0.34:8181/user')
    const result = await response.json()

    console.log(result);
  }

  tt()
})
