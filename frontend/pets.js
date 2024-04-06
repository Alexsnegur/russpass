document.addEventListener('DOMContentLoaded', () => {
	const main = document.querySelector('body')
  const containerPets = document.createElement('div')
  const itemIcon = document.createElement('div')
	const wrapperChat = document.createElement('div')

	const mechat = document.createElement('div')
	const mechatIcon = document.createElement('div')
	const mechatText = document.createElement('div')

	containerPets.classList.add('petsContainer')
	wrapperChat.classList.add('petsContainer__wrapper-chat')
	itemIcon.classList.add('petsContainer__itemIcon')
	mechat.classList.add('petsContainer__mechat-container')
	mechatText.classList.add('petsContainer__mechat-text')
	mechatIcon.classList.add('petsContainer__mechat-icon')

	// item.style.background = `url(${'./img/pes.png'}) center center no-repeat / cover`

	// mechat.innerHTML = `
	// <svg preserveAspectRatio="none" fill="none" xmlns="http://www.w3.org/2000/svg">
	// <path fill-rule="evenodd" clip-rule="evenodd" d="M211.191 19.3667C211.69 18.164 211.954 16.9063 211.954 15.6119C211.954 6.98969 200.221 0 185.747 0C174.739 0 165.316 4.04306 161.435 9.77243C159.631 9.58425 157.767 9.48573 155.862 9.48573C154.87 9.48573 153.889 9.51245 152.922 9.56464C148.365 3.93241 138.015 0 125.977 0C112.862 0 101.751 4.66756 97.9509 11.1156C97.1859 11.0832 96.4126 11.0667 95.6322 11.0667C91.4077 11.0667 87.3911 11.551 83.7598 12.423C80.9404 7.23715 73.8359 3.55713 65.5172 3.55713C57.4877 3.55713 50.5894 6.98576 47.584 11.8878C44.9231 10.3663 41.7705 9.48573 38.3908 9.48573C36.0275 9.48573 33.7753 9.91627 31.7246 10.6955C28.653 6.39969 23.3138 3.55714 17.2414 3.55714C7.71923 3.55714 0 10.5468 0 19.169C0 23.296 1.76848 27.049 4.65667 29.8405C1.76848 32.632 0 36.3849 0 40.5119C0 44.4545 1.61398 48.0557 4.2763 50.8035C3.59437 52.6273 3.21844 54.6239 3.21844 56.7167C3.21844 65.3389 9.59967 72.3286 17.4713 72.3286C20.7919 72.3286 23.8473 71.0847 26.2704 68.9992C31.4869 71.56 38.3973 73.119 45.9771 73.119C46.6331 73.119 47.284 73.1074 47.9293 73.0844C51.0955 78.9538 57.7814 83 65.5172 83C71.1474 83 76.2215 80.8567 79.7872 77.4271C83.1706 77.2982 86.3963 76.8581 89.3681 76.1591C93.152 80.3203 99.0815 83 105.747 83C113.468 83 120.201 79.4047 123.756 74.0761C129.958 79.4047 141.704 83 155.173 83C174.633 83 190.497 75.4942 191.237 66.099C195.152 70.374 201.226 73.1191 208.046 73.1191C219.853 73.1191 229.425 64.8907 229.425 54.7405C229.425 52.0677 228.762 49.5282 227.568 47.2371C234.739 45.3555 240 39.1642 240 31.8167C240 22.9762 232.384 15.8095 222.989 15.8095C218.937 15.8095 215.217 17.142 212.295 19.3667H211.191Z" fill="#A2B1FF"/>
	// </svg>
	// `
	// preserveAspectRatio="none"
	mechat.innerHTML = `
<svg preserveAspectRatio="none" width="520" height="219" viewBox="0 0 520 219" fill="none" xmlns="http://www.w3.org/2000/svg">

		<circle cx="170.5" cy="139.5" r="79.5" fill="#A2B1FF"/>
		<ellipse cx="81.5" cy="162" rx="65.5" ry="48" fill="#A2B1FF"/>
		<circle cx="60.5" cy="102.5" r="60.5" fill="#A2B1FF"/>
		<ellipse cx="139.5" cy="77" rx="70.5" ry="75" fill="#A2B1FF"/>
		<ellipse cx="310.5" cy="82.5" rx="63.5" ry="41.5" fill="#D9D9D9"/>
		<ellipse cx="294" cy="81" rx="73" ry="81" fill="#A2B1FF"/>
		<ellipse cx="306" cy="143.5" rx="55" ry="66.5" fill="#A2B1FF"/>
		<ellipse cx="375" cy="99.5" rx="69" ry="57.5" fill="#A2B1FF"/>
		<ellipse cx="249.5" cy="165.5" rx="61.5" ry="41.5" fill="#A2B1FF"/>
		<ellipse cx="375" cy="52" rx="50" ry="51" fill="#A2B1FF"/>
		<ellipse cx="395.5" cy="166" rx="62.5" ry="44" fill="#A2B1FF"/>
		<ellipse cx="436.5" cy="59.5" rx="58.5" ry="52.5" fill="#A2B1FF"/>
		<ellipse cx="436.5" cy="126.5" rx="83.5" ry="59.5" fill="#A2B1FF"/>
		<ellipse cx="221" cy="53" rx="58" ry="50" fill="#A2B1FF"/>
		<ellipse cx="86" cy="77" rx="48" ry="64" fill="#A2B1FF"/>
		</svg>	
	`

	mechatText.innerHTML = 'Пишу о какой то хуйне даюы заполнить пространство в этой ебанной хуйне ало чириы воылв ыдвлыь вылвьты тылы ыл л ыл воыовлыо л'

	mechat.append(mechatIcon, mechatText)
	wrapperChat.append(mechat)
	containerPets.append(itemIcon, wrapperChat)
	main.append(containerPets)
	return containerPets
})
