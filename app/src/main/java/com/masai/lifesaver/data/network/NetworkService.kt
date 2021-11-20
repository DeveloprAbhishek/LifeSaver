package com.masai.lifesaver.data.network

import com.masai.lifesaver.simulator.WebSocket
import com.masai.lifesaver.simulator.WebSocketListener

class NetworkService {

    fun createWebSocket(webSocketListener: WebSocketListener): WebSocket {
        return WebSocket(webSocketListener)
    }

}