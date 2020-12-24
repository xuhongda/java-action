let WsUrl ={
    textHttps:'wss://test.cpsdna.com/dpe/',
    devHttp:'ws://58.215.50.61:8309/dpe/'
}
let url = ''

if(window.location.protocol == 'https:'){
    url = WsUrl.textHttps
} else {
    url = WsUrl.devHttp
}
 
export default url