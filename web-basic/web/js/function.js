import {
  compare,
  compare_edition,
} from './car.js'

import wsUrl from './config.js';


let biasX = 0,
  biasY = 0,
  biasZ = 0;

document.querySelector('#biasBtn').onclick = function () {
  biasY = Y_axle.innerHTML.split('°')[0] * 1
  biasZ = Z_axle.innerHTML.split('°')[0] * 1
  biasX = X_axle.innerHTML.split('°')[0] * 1
}





// url分割
export function getQueryVariable(variable) {
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split("=");
    if (pair[0] == variable) {
      return pair[1];
    }
  }
  return (false);
}



//获取时间
export function getNowFormatDate(time) {
  let date = new Date(time);
  let year = date.getFullYear();
  let month = date.getMonth() + 1;
  let strDate = date.getDate();
  let hours = date.getHours();
  let minutes = date.getMinutes();
  let seconds = date.getSeconds();

  return hours + ':' + minutes + ':' + seconds;;
}




let flag_data = 1; // 关于紧急事件的开关
let urgArr = []; //  关于紧急事件存储的数组

let Y_axle = document.querySelector('#Y_axle')
let X_axle = document.querySelector('#X_axle')
let Z_axle = document.querySelector('#Z_axle')

//数据处理
export function dispose(data) {

  // data = {
  //   did: "359647090443099",
  //   dt: "jimi-ubi",
  //   et: 0,
  //   maxAcc: 0,
  //   sp: "118.70363,32.040085,6.0,0,0.3,1.9,0.0,0.0,0.0,39.0;118.70363,32.040085,6.0,0,0.2,1.9,0.0,-1.0,0.0,60.0;118.70363,32.040085,6.0,0,0.0,1.9,0.0,-1.0,0.0,81.0;118.70363,32.040085,6.0,0,0.3,1.8,0.0,0.0,0.0,98.0;118.70363,32.040085,7.0,0,0.8,-0.8,0.0,0.0,0.0,99.0;118.70363,32.040085,8.0,0,0.8,0.2,0.0,0.0,0.0,0.0;",
  //   spInv: 1000,
  //   spNum: 3,
  //   t: "2020-09-25 10:02:32",
  //   ts: 1600999352000,
  //   type: "URGEVENT",
  //   vid: "20200924102412345",
  // }


  let {
    ya,
    za,
    xa,
    type,
    ts,
    t,
    dt,
  } = data



  // 异常数据抛出
  if (data.xr == 6425 || (za == 0 && xa == 0 && ya == 0)) {
    return
  }

  // 是 GPS 包 且 紧急事件并没有在执行中
  if (type == 'GPS' && flag_data == 1) {

    let xr = (data.zr * 1 - biasX).toFixed(1); //俯仰角   坐标系转换  设备坐标系 zr = xr
    let yr = (data.xr * 1 - biasY).toFixed(1); //航向角   坐标系转换  设备坐标系 xr = yr
    let zr = (data.yr * 1 - biasZ).toFixed(1); //横滚角   坐标系转换  设备坐标系 yr = zr

    //调用旋转函数
    // compare({
    //   xr,
    //   yr: -yr,
    //   zr: -zr,
    //   type: 'GPS'
    // })

    compare_edition({
      xr,
      yr,
      zr,
      type,
    })

    // 姿态角 角度赋值
    Y_axle.innerHTML = yr + '°'
    X_axle.innerHTML = xr + '°'
    Z_axle.innerHTML = zr + '°'

  } else if (type == 'URGEVENT' && flag_data !== 2) {
    // 紧急事件
    flag_data = 2
    console.log('紧急事件开始执行');
    // 分割大数据包  280个点
    let spArr = data.sp.split(';');
    // 格式化数据
    urgArr = spArr.map((item, index) => {
      let itemArr = item.split(',')
      if (itemArr.length != 1) {
        return {
          lng: Number(itemArr[0]),
          lat: Number(itemArr[1]),
          spd: Number(itemArr[2]),
          xa: Number(itemArr[4]),
          ya: Number(itemArr[5]),
          za: Number(itemArr[6]),
          yr: Number(itemArr[9]),
          zr: Number(itemArr[7]),
          xr: Number(itemArr[8]),
        }
      }
    })
    //抛弃废数据
    urgArr.pop()


    // 计数器
    let i = 0;
    let timer = setInterval(() => {
      if (i == urgArr.length) {
        // 紧急事件执行完毕 
        // 关闭定时器
        clearInterval(timer)
        // 打开开关
        flag_data = 1
        console.log('紧急事件执行完毕');
        // 清空事件包存储数据数组
        urgArr = []
        return
      }
      if (i <= urgArr.length - 1) {
        let {
          xa,
          ya,
          za,
          yr,
          zr,
          xr,
          spd
        } = urgArr[i]
        // compare({
        //   xr,
        //   yr: -yr,
        //   zr: -zr,
        //   type: 'URGEVENT',
        //   dt,
        // })

        compare_edition({
          xr,
          yr: yr,
          zr: zr,
          type: 'URGEVENT',
        })

        Y_axle.innerHTML = yr + '°'
        X_axle.innerHTML = xr + '°'
        Z_axle.innerHTML = zr + '°'

      }
      i++
    }, dt == "jimi-ubi" ? 1000 : 50)

  } else {
    console.log('屏蔽');
  }
}



let againNum = 0; // 重连计数




export function wsInit(response, userId) {
  // 开发
  // let ws = new WebSocket("ws://192.168.2.223:28617/dpe/websocket/vehicle/pos?userId=" + userId + "&token=" + response.data.detail.token + "&initSendAllData=1"); 
  // 测试
  // let ws = new WebSocket("ws://58.215.50.61:8309/dpe/websocket/vehicle/pos?userId=" + userId + "&token=" + response.data.detail.token + "&initSendAllData=1");

  let ws = new WebSocket(wsUrl + "websocket/vehicle/pos?userId=" + userId + "&token=" + response.data.detail.token + "&initSendAllData=1")


  ws.onopen = function () {
    console.log('ws通道建立成功');
  }

  ws.onmessage = function (msg) {
    // console.log("ws数据回来了")
    let data = JSON.parse(msg.data)
    dispose(data)

  };
  ws.onclose = function (evt) {
    console.log("ws连接关闭,2秒后重连");
    if (againNum < 3) {
      againNum++
    } else {
      againNum = 0
      return
    }
    setTimeout(() => {
      console.log('开始重连');
      wsInit(response, userId)
    }, 2000)
  };

  ws.onerrer = function (evt) {
    console.log(evt);
  };

}