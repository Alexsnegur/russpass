import templates

name_pet = "Кот"
gigachat_credentials="OGNkNTkyMDYtMGVjMC00MDdhLWFiZmQtOWU3ZWVjZmM4YzY3OmQ3Y2MzYTM2LTUwOGQtNDZhNS04MDZiLTQ3Yzg0NGI1YWM3Yw=="
gigachat_scope="GIGACHAT_API_PERS"
variation = [templates.place, templates.place, templates.place, templates.place, templates.joke, templates.joke, templates.mega_joke]
mega_joke_variation = [templates.mega_joke]*7
place_variation = [templates.place]*7
joke_variation = [templates.joke]*7
topics = ["путешествие", "отель", "ресторан", "экскурсия", "авиа билеты", "жд билеты", "погода"]
links_original_site= {'места и события': 'https://russpass.ru/?destination=5d08e36dad3a9a001701b95b&tab=event',
         'экскурсии': 'https://russpass.ru/?destination=5d08e36dad3a9a001701b95b&tab=excursion',
         'жилье': 'https://russpass.ru/?destination=5d08e36dad3a9a001701b95b&tab=housing',
         'рестораны': 'https://russpass.ru/?destination=5d08e36dad3a9a001701b95b&tab=restaurant',
         'авиабилеты': 'https://russpass.ru/?destination=5d08e36dad3a9a001701b95b&tab=avia',
         'жд билеты': 'https://russpass.ru/?destination=5d08e36dad3a9a001701b95b&tab=railway',
         'рекомендации': 'https://russpass.ru/?destination=5d08e36dad3a9a001701b95b&tab=track',
         'планирование путешествия': 'https://russpass.ru/wishlist?tab=favorite',
         'лидерборд': 'https://russpass.ru/wishlist?tab=housing'}
links_our_copy = {'профиль пользователя': 'http://192.168.0.34:8082/main/index.html',
                  'жилье': 'http://192.168.0.34:8082/list-hotel/index.html',
                  'лидерборд': 'http://192.168.0.34:8082/liderbord/lider-bord.html',
                  'авторизация на сайте': 'http://192.168.0.34:8082/auth/auth.html',
                  'профиль питомца': 'http://192.168.0.34:8082/profile/profile.html'}
