# crypto-ticker

<h3>Introduction</h3>
Crypto-ticker is an android application written with the Model-View-ViewModel design pattern. Latest Bitcoin data are shown and updated in real-time by connecting to a websocket. Users can be informed about the latest changes on the currency and set alarms for specific prices. When market and alarm prices match the app pops up a notification. There's also a news page where latest bitcoin related news are displayed.

<h3>Used technologies</h3>

* Android Architecture Components
  - ViewModel
  - Room
  - LiveData
  
* Data Binding

* Retrofit 2

* Okhttp
  - WebsocketListener

* Dagger 2

* MPAndroidChart

* Picasso

* Butterknife


<h3>Screenshots</h3>
<p float="left">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/detail_tick.gif?raw=true" width="425">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/alarm_add.gif?raw=true" width="425">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/alarm_trigger.gif?raw=true" width="425">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/news.png?raw=true" width="425">
</p>


<h3>Consumed API's</h3>
Bitcoin Average: https://bitcoinaverage.com 

News Api: https://newsapi.org

