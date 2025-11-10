package com.globe.three_dimensional_globe.controller

import com.globe.three_dimensional_globe.dto.MessageDto
import com.globe.three_dimensional_globe.service.ChatbotService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chatbot")
class ChatbotController(
    private val chatbotService: ChatbotService
) {

    @PostMapping
    fun genChatbot(
        @RequestBody messageDto: MessageDto
    ): MessageDto {
        return chatbotService.genChatbotMessage(messageDto)
    }
}