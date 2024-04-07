const ws = require('ws')
const {v4} = require('uuid')
const {Server} = ws
const clients = {}
const messages = []

const wss = new Server({port: 5678})

wss.on('connection', (ws) => {
  const id = v4()
  clients[id] = ws

  // console.log(clients[id], clients, id);

  ws.send(JSON.stringify(messages))

  ws.on('message', (rawMessage) => {
    console.log(rawMessage);
    const str = '' + rawMessage
    console.log(str);
    const {name, message} = JSON.parse(str)
    messages.push({name, message})

    for(let id in clients) {
      clients[id].send(JSON.stringify([{name, message}]))
    }


  })

  ws.on('close', () => {
    delete clients[id]
    // console.log('delete ', clients[id]);
  })
})
