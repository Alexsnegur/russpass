import random

from langchain.schema import HumanMessage, SystemMessage

import setting
import templates


def descript_place(chat, user_input):
    variation = setting.variation
    mes_place = [
        SystemMessage(
            content=templates.system.format(petname=setting.name_pet)
        ),
        HumanMessage(content=variation[random.randint(0, 6)].format(place=user_input))
    ]
    res = chat(mes_place)
    return res.content


def answer(chat, messages, user_input, topics):
    links = ''
    for key, value in setting.links_original_site.items():
        links += ', {}: {}'.format(key, value)
    messages.append(HumanMessage(content=templates.answer.format(links=links, topics=', '.join(topics), question=user_input)))
    res = chat(messages)
    messages.append(res)
    return res.content
