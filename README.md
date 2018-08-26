# crypto-ticker

<h3>Introduction</h3>
Crypto-ticker is an android application written with the MVVM design pattern. Latest Bitcoin data are shown and updated in 
real-time. It's done so by connecting to a websocket which provides Bitcoin data in real-time. 
Additionally it allows users to set alarms for specific prices. When market and alarm prices match the app pops up a 
notification even when the app is closed. There's also a page where latest bitcoin related news are displayed.

<h3>Used technologies</h3>

* Android Architecture Components
  - ViewModel
  - Room
  - LiveData
  
* Retrofit 2

* Okhttp
  - WebsocketListener

* Dagger 2

* MPAndroidChart

* Picasso


<h3>Screenshots</h3>
<p float="left">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/detail_tick.gif?raw=true" width="425">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/alarm_add.gif?raw=true" width="425">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/alarm_trigger.gif?raw=true" width="425">
<img src="https://github.com/mertemir/crypto-ticker/blob/master/screenshots/news.gif?raw=true" width="425">
</p>


<h3>Consumed API's</h3>
Bitcoin Average: https://bitcoinaverage.com 

News Api: https://newsapi.org

