from typing import Annotated

from fastapi import FastAPI, Form
from langchain.chat_models.gigachat import GigaChat
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel

from util import *

class Mes(BaseModel):
    data: str

app = FastAPI()
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=["*"],
    allow_methods=["*"],
    allow_headers=["*"],
)

chat = GigaChat(credentials=setting.gigachat_credentials,
                verify_ssl_certs=False, top_p=0.3)

topics = setting.topics

messages = [SystemMessage(content=templates.system.format(petname=setting.name_pet))]

@app.post("/answering")
def answering(data: Annotated[str, Form()]):
    res = answer(chat=chat, messages=messages, user_input=data, topics=topics)
    return {"message": res}

@app.post("/set_name")
def answering(petname: Annotated[str, Form()]):
    setting.name_pet = petname


@app.post("/descript_place")
def descript(data: Annotated[str, Form()]):
    res = descript_place(chat=chat, user_input=data)
    return {"message": res}
