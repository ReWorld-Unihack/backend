(function() {
	var chat = {
		showLoader: () => {
	      document.querySelector('#message-loader').style.display = 'block'
	    },
	    hiddenLoader: () => {
	      document.querySelector('#message-loader').style.display = 'none'
	    },
		getResponseGPT:         // Hàm gọi API OpenAI
			function callOpenAI() {
				this.showLoader()
				const apiKey = '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'; // Thay 'YOUR_API_KEY' bằng khóa API của bạn
				const asks = document.querySelectorAll('.message.other-message')
				let ask = asks[asks.length - 1].textContent.replace(/\s/g, '').toLowerCase();
				const inputText = ask;
				var templateResponse = Handlebars.compile($("#message-response-template").html());
				fetch('https://api.openai.com/v1/chat/completions', {
					'method': 'POST',
					'headers': {
						'Content-Type': 'application/json',
						'Authorization': `Bearer ${apiKey}`
					},
					'body': JSON.stringify({
						//'prompt': inputText,
						'max_tokens': 200,
						'model': 'gpt-3.5-turbo',
						"messages": [
							{
								"role": "user",
								"content": inputText
							}
						]
					})
				})
					.then(response => response.json())
					.then(data => {
						// Xử lý phản hồi từ API
						const outputText = data.choices[0].message.content;
						var contextResponse = {
							response: outputText,
							time: this.getCurrentTime()
						};
						this.$chatHistoryList.append(templateResponse(contextResponse));
						this.scrollToBottom();
						this.hiddenLoader()

					})
					.catch(error => {
						console.error('Lỗi khi gọi API:', error);
					});
			},
		keyword: ['xin chào', 'tai nạn', 'đắt không', 'gói dịch vụ', 'quá trình hỏa táng', 'là gì'],
		messageToSend: '',
		init: function() {
			this.cacheDOM();
			this.bindEvents();
			this.render();
		},
		cacheDOM: function() {
			this.$chatHistory = $('.chat-history');
			this.$button = $('button');
			this.$textarea = $('#message-to-send');
			this.$chatHistoryList = this.$chatHistory.find('ul');
		},
		bindEvents: function() {
			this.$button.on('click', this.addMessage.bind(this));
			this.$textarea.on('keyup', this.addMessageEnter.bind(this));
		},
		render: function() {
			this.scrollToBottom();
			if (this.messageToSend.trim() !== '') {
				var template = Handlebars.compile($("#message-template").html());
				var context = {
					messageOutput: this.messageToSend,
					time: this.getCurrentTime()
				};

				this.$chatHistoryList.append(template(context));
				this.scrollToBottom();
				this.$textarea.val('');
				// responses
				var templateResponse = Handlebars.compile($("#message-response-template").html());
				this.getResponseGPT();

			}
		},

		addMessage: function() {
			this.messageToSend = this.$textarea.val()
			this.render();
		},
		addMessageEnter: function(event) {
			// enter was pressed
			if (event.keyCode === 13) {
				this.addMessage();
			}
		},
		scrollToBottom: function() {
			this.$chatHistory.scrollTop(this.$chatHistory[0].scrollHeight);
		},
		getCurrentTime: function() {
			return new Date().toLocaleTimeString().
				replace(/([\d]+:[\d]{2})(:[\d]{2})(.*)/, "$1$3");
		},
		getRandomItem: function(arr) {
			return arr[Math.floor(Math.random() * arr.length)];
		},


	};

	chat.init();

})();
