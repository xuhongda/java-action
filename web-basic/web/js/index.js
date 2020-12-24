import {
    carBox,
} from './car.js'
import {
    point,
    ambient
} from './background.js'

import * as fun from './function.js'


//获取dom
let car_box = document.querySelector('body');
// 建立场景
export let scene = new THREE.Scene();

scene.add(carBox)
scene.add(point)
scene.add(ambient)


// 辅助对象
// let scene_axisHelper = new THREE.AxisHelper(1000);
// scene.add(scene_axisHelper)

// let car_axisHelper = new THREE.AxisHelper(1000);
// carBox.add(car_axisHelper)
// carBox.position.z = 20

// 建立相机
let width = car_box.offsetWidth;
let height = car_box.offsetHeight;
let k = width / height;
let camera = new THREE.PerspectiveCamera(60, k, 0.1, 8000);
//相机位置
camera.position.set(0, 25,50)
camera.lookAt(carBox.position)


// 建立渲染器
let renderer = new THREE.WebGLRenderer({
    antialias: true,
    alpha: true
});
renderer.setClearAlpha(0.0);
renderer.setSize(width, height);
car_box.appendChild(renderer.domElement);
renderer.render(scene, camera);



window.onload = function(){
    advance()
}

function advance() {

    requestAnimationFrame(advance);
    renderer.render(scene, camera);
}

let controls = new THREE.OrbitControls(camera, renderer.domElement); //创建控件对象
