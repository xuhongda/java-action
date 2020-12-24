import {
    scene
} from './index.js'


export let car = new THREE.Object3D()
export let carBox = new THREE.Object3D()
export let gltfBox = null

// let Y_axle = document.querySelector('#Y_axle')

let yV = document.querySelector('#y')
let zV = document.querySelector('#z')
let xV = document.querySelector('#x')
let gpsV = document.querySelector('#gps')
document.onkeydown = function (event) {
    var e = event || window.event;
    if (e && e.keyCode == 13) { //回车键的键值为13
        compare_edition({
            yr: yV.value,
            xr: xV.value,
            zr: zV.value,
            // type: gpsV.value
            type: 'GPS'
        })

        // compare({
        //     yr: -yV.value,
        //     xr: xV.value,
        //     zr: -zV.value,
        //     type: 'GPS'
        // })
    }
};



// 余
// let loader = new THREE.GLTFLoader();
// loader.load('images/car.gltf', function (gltf) {
//     gltf.scene.traverse(function (gltf) {
//         if (gltf.isMesh) {
//             gltf.material.emissive = gltf.material.color;
//             gltf.material.emissiveMap = gltf.material.map;
//         }
//     });
//     gltf.scene.scale.set(0.1, 0.1, 0.1);
//     gltfBox = gltf.scene
//     car.add(gltf.scene); // 将模型引入three
// })
// carBox.add(car)

// let loader = new THREE.GLTFLoader();
// loader.load('images/lancer.gltf', function (gltf) {
//     gltf.scene.traverse(function (gltf) {
//         if (gltf.isMesh) {
//             gltf.material.emissive = gltf.material.color;
//             gltf.material.emissiveMap = gltf.material.map;
//         }
//     });
//     gltf.scene.scale.set(0.05, 0.05, 0.05);
//     gltfBox = gltf.scene
//     car.add(gltf.scene); // 将模型引入three
// })
// carBox.add(car)

var mtlLoader = new THREE.MTLLoader();
mtlLoader.load('images/lancer.mtl', function(materials) {

    materials.preload();

    var objLoader = new THREE.OBJLoader();
    objLoader.setMaterials(materials);
    objLoader.load('images/lancer.obj', function(object) {

        object.position.z = 10

        // object.rotation.z = Math.PI
        object.scale.set(0.04, 0.04, 0.04);
        car.add(object);
        gltfBox = object
    });
});

carBox.add(car)






// 老爷车
// var mtlLoader = new THREE.MTLLoader();
// mtlLoader.load('images/car/obj.mtl', function (materials) {
//     materials.preload();

//     var objLoader = new THREE.OBJLoader();
//     objLoader.setMaterials(materials);
//     objLoader.load('images/car/obj.obj', function (object) {

//         console.log(object);
//         object.scale.set(0.1, 0.1, 0.1);

//         gltfBox = object
//         car.add(object);
//     });

// });
// carBox.add(car)







// 纪
// var texture = new THREE.TextureLoader().load('images/qiche.jpg');
// var material = new THREE.MeshBasicMaterial({
//     map: texture
// });

// var objLoader = new THREE.OBJLoader();
// objLoader.load('images/qiche.obj', function (object) {
//     object.traverse(function (child) {
//         if (child instanceof THREE.Mesh) {
//             child.material  = material;
//         }
//     });
//     console.log(object);
//     object.scale.set(0.1, 0.1, 0.1);

//     gltfBox = object
//     car.add(object);
// });

// carBox.add(car)





// var texture = new THREE.TextureLoader().load('images/10_0068.jpg');
// var material = new THREE.MeshBasicMaterial({
//     map: texture
// });

// var objLoader = new THREE.OBJLoader();
// objLoader.load('images/10.obj', function (object) {
//     object.traverse(function (child) {
//         if (child instanceof THREE.Mesh) {
//             child.material  = material;
//         }
//     });
//     console.log(object);
//     object.scale.set(0.1, 0.1, 0.1);

//     gltfBox = object
//     car.add(object);
// });

// carBox.add(car)



// var mtlLoader = new THREE.MTLLoader();
// mtlLoader.load('images/MAZDA6.mtl', function(materials) {

//     materials.preload();

//     var objLoader = new THREE.OBJLoader();
//     objLoader.setMaterials(materials);
//     objLoader.load('images/MAZDA6.obj', function(object) {

//         object.position.x = -5;
//         object.position.y = -10;
//         // object.rotation.y = 0.5;
//         object.rotation.y = Math.PI
//         object.scale.set(0.3, 0.3, 0.3);
//         car.add(object);
//         gltfBox = object
//     });
// });

// carBox.add(car)






// var mtlLoader = new THREE.MTLLoader();
// mtlLoader.load('images/lanbo/obj.mtl', function(materials) {

//     materials.preload();

//     var objLoader = new THREE.OBJLoader();
//     objLoader.setMaterials(materials);
//     objLoader.load('images/lanbo/obj.obj', function(object) {

//         object.position.y = 0;
//         object.rotation.y = 0.5;
//         object.scale.set(0.05, 0.05, 0.05);
//         car.add(object);
//         gltfBox = object
//     });
// });

// carBox.add(car)














// 存储上一次的度数  用于跟下一次的比较差异
let x_old = 0,
    y_old = 0,
    z_old = 0;

// 度数转换 1 = angle °
let angle = (180 / Math.PI);
export function compare({
    xr = 0,
    yr = 0,
    zr = 0,
    type = '',
    dt
}) {
    // 类型转换
    xr *= 1
    yr *= 1
    zr *= 1
    // 过滤 数据类型为GPS包的第一次调用 以及 事件包;
    if (type != 'GPS' || (z_old == 0 && y_old == 0 && x_old == 0)) {


        if (dt == "jimi-ubi") {
            // if (yr >= 0 || y_old >= 0) {
            //     y_result_new = (y_old + yr) / angle
            //     let y = -(y_old + yr) >= 360?-(y_old + yr) - 360: -(y_old + yr);
            //     Y_axle.innerHTML = y + '°'
            //     y_old = -y
            // } else if (yr < 0 && y_old < 0) {
            //     y_result_new = -(y_old + yr) / angle
            //     let y = -(y_old + yr) >= 360?-(y_old + yr) - 360:-(y_old + yr)
            //     Y_axle.innerHTML = y + '°'
            //     y_old = -y
            // }


            // 声明变量
            let y_ratio = 0,
                z_ratio = 0,
                x_ratio = 0;

            // 计算   新老度数之差   分12份变化  最后 将度数 转换为数值
            y_ratio = calcuY(yr, y_old) / 12 / angle;
            x_ratio = calcuX(xr, x_old) / 12 / angle;
            z_ratio = calcuZ(zr, z_old) / 12 / angle;

            // 声明 四元数 对象
            let quaternion_car = new THREE.Quaternion()
            let quaternion_gltfBox = new THREE.Quaternion()
            let quaternion_carBox = new THREE.Quaternion()

            // 声明 欧拉角 对象
            let euler_car = new THREE.Euler(0, y_ratio, 0, 'XYZ')
            let euler_carBox = new THREE.Euler(0, 0, z_ratio, 'XYZ')
            let euler_gltfBox = new THREE.Euler(x_ratio, 0, 0, 'XYZ')

            // 将欧拉角转换为四元数
            quaternion_car.setFromEuler(euler_car)
            quaternion_carBox.setFromEuler(euler_carBox)
            quaternion_gltfBox.setFromEuler(euler_gltfBox)

            // 计数器 运行一次 加 1 
            let flag = 0;
            // 将A设为循环定时器
            let a = setInterval(() => {

                //当 运行 12次以后 关闭 自身
                if (flag >= 12) {
                    clearInterval(a)
                    return
                }
                // 将 1/12 的四元数  重复添加进 几何体的四元数
                car.applyQuaternion(quaternion_car);
                gltfBox.applyQuaternion(quaternion_gltfBox);
                carBox.applyQuaternion(quaternion_carBox)
                flag++
            }, 60)



        } else {

            let x_result_new = 0,
                y_result_new = 0,
                z_result_new = 0;

            //计算 度数与数值的转换  根据基础公式：2π = 360°
            x_result_new = xr / angle;
            z_result_new = zr / angle;
            y_result_new = yr / angle;
            //将度数转换为 欧拉角 
            let group_Euler_new = new THREE.Euler(0, y_result_new, 0, 'XYZ')
            let euler_carBox = new THREE.Euler(0, 0, z_result_new, 'XYZ')
            let group_Euler_gltfBox = new THREE.Euler(x_result_new, 0, 0, 'XYZ')
            // 将欧拉角转换为4元数
            car.quaternion.setFromEuler(group_Euler_new)
            carBox.quaternion.setFromEuler(euler_carBox)
            gltfBox.quaternion.setFromEuler(group_Euler_gltfBox)

        }

        //存储度数
        z_old = zr
        x_old = xr
        // if (dt !== "jimi-ubi") {
        y_old = yr
        // } 
        return


    } else {
        // 声明变量
        let y_ratio = 0,
            z_ratio = 0,
            x_ratio = 0;

        // 计算   新老度数之差   分12份变化  最后 将度数 转换为数值
        y_ratio = calcuY(yr, y_old) / 12 / angle;
        x_ratio = calcuX(xr, x_old) / 12 / angle;
        z_ratio = calcuZ(zr, z_old) / 12 / angle;

        // 声明 四元数 对象
        let quaternion_car = new THREE.Quaternion()
        let quaternion_gltfBox = new THREE.Quaternion()
        let quaternion_carBox = new THREE.Quaternion()

        // 声明 欧拉角 对象
        let euler_car = new THREE.Euler(0, y_ratio, 0, 'XYZ')
        let euler_carBox = new THREE.Euler(0, 0, z_ratio, 'XYZ')
        let euler_gltfBox = new THREE.Euler(x_ratio, 0, 0, 'XYZ')

        // 将欧拉角转换为四元数
        quaternion_car.setFromEuler(euler_car)
        quaternion_carBox.setFromEuler(euler_carBox)
        quaternion_gltfBox.setFromEuler(euler_gltfBox)

        // 计数器 运行一次 加 1 
        let flag = 0;
        // 将A设为循环定时器
        let a = setInterval(() => {
            //当 运行 12次以后 关闭 自身
            if (flag >= 12) {
                clearInterval(a)

                return
            }
            // 将 1/12 的四元数  重复添加进 几何体的四元数
            car.applyQuaternion(quaternion_car);
            gltfBox.applyQuaternion(quaternion_gltfBox);
            carBox.applyQuaternion(quaternion_carBox)
            flag++
        }, 60)

        z_old = zr
        x_old = xr
        y_old = yr
    }
}



// 计算相差的度数

function calcuY(a, b) {
    // 参数说明  a = 新的角度  b = 老的角度
    // Y轴 新角度与旧角度 都为负数 跟设备保持一致
    // 当新角度大于旧角度时  用新角度  减去旧角度等于 相差的角度
    let value;
    // if (Math.abs(a) > Math.abs(b)) {
    //     //顺时针旋转 
    //     //新角度大于旧角度
    //     if (Math.abs(a) + b < 180) {
    //         value = -(Math.abs(a) + b)
    //     } else {
    //         value = -(Math.abs(a) + b) + 360
    //     }
    //     return value
    // } else {
    //     // 逆时针旋转
    //     // 旧角度大于新角度
    //     if (Math.abs(b) - Math.abs(a) < 180) {
    //         value = Math.abs(b) - Math.abs(a)
    //     } else {
    //         value = Math.abs(b) - Math.abs(a) - 360
    //     }
    //     return value
    // }

    // y轴运动轨迹与设备相反，所以参数传的时候就为反数，越小的越大
    if (a < b) {
        // 顺时针 return出一个负值
        if (Math.abs(a) - Math.abs(b) < 180) {
            value = -(Math.abs(a) - Math.abs(b))
        } else {
            value = -(Math.abs(a) - Math.abs(b)) + 360
        }
    } else {
        // 逆时针 return出一个正值
        if (Math.abs(b) - Math.abs(a) < 180) {
            value = Math.abs(b) - Math.abs(a)
        } else {
            value = (Math.abs(b) - Math.abs(a)) - 360
        }
    }
    return value
}

function calcuX(a, b) {
    // 参数说明  a = 新的角度  b = 老的角度
    // X轴 正值为抬头  负值为低头
    if (a >= 0 && b >= 0) {
        //抬头的动作
        return a - b
    } else if (a <= 0 && b >= 0 || a >= 0 && b <= 0) {
        // 低头的动作
        if (a >= 0) {
            //当 A >=0 时，代表 B 就小于等于 0 移动的度数 = 正的 a+b
            return a - b
        } else {
            //反之 b 就 大于等于 0 移动的度数 = 负的 a+b
            return a - b
        }
    } else {
        // 第三个判断 无非就是 a < 0  b < 0  同向
        return -(Math.abs(a) - Math.abs(b))
    }
}

function calcuZ(a, b) {
    let value;
    // Z轴 新角度与旧角度 都为负数 跟设备保持一致
    if (a <= 0 && b <= 0) {
        //右倾斜
        if (Math.abs(a) > Math.abs(b)) {
            return -(Math.abs(a) - Math.abs(b))
        } else {
            return Math.abs(b) - Math.abs(a)
        }
    } else if (a <= 0 && b >= 0 || a >= 0 && b <= 0) {
        if (a >= 0) {
            //往左转
            //当 A >=0 时，代表 B 就小于等于 0
            if (a + Math.abs(b) > 180) {
                value = a + Math.abs(b) - 360
            } else {
                value = a + Math.abs(b)
            }
            return value
        } else {
            //往右转
            //反之 b 就 大于等于 0
            if (-(Math.abs(a) + b) < -180) {
                value = -(Math.abs(a) + b) + 360
            } else {
                value = -(Math.abs(a) + b)
            }
            return value
        }
    } else {
        // 第三个判断 无非就是 a > 0  b > 0
        return a - b
    }
}


let xr_O = 0,
    yr_O = 0,
    zr_O = 0;



export function compare_edition({
    xr = 0,
    yr = 0,
    zr = 0,
    tpye = ''
}) {
    xr *= 1
    yr *= 1
    zr *= 1
    if (tpye != 'GPS' && xr_O == 0 && yr_O == 0 && zr_O == 0) {
        let y = (yr / angle).toFixed(14),
            z = (zr / angle).toFixed(14),
            x = (xr / angle).toFixed(14);

        let car_euler = new THREE.Euler(0, 0, -z, 'XYZ')
        let carBox_euler = new THREE.Euler(0, -y, 0, 'XYZ')
        let gltfBox_euler = new THREE.Euler(x, 0, 0, 'XYZ')

        car.quaternion.setFromEuler(car_euler)
        carBox.quaternion.setFromEuler(carBox_euler)
        gltfBox.quaternion.setFromEuler(gltfBox_euler)

        // scene.quaternion.setFromEuler(carBox_euler)  
    } else {

        let y, z, x;
        // let y = (((yr / angle).toFixed(14) - (yr_O / angle).toFixed(14)) / 12).toFixed(14),
        //     z = (((zr / angle).toFixed(14) - (zr_O / angle).toFixed(14)) / 12).toFixed(14),
        //     x = (((xr / angle).toFixed(14) - (xr_O / angle).toFixed(14)) / 12).toFixed(14);


        // y的计算过程
        if (yr > yr_O) {
            y = yr - yr_O > 180 ? yr - yr_O - 360 : yr - yr_O;
        } else {
            y = yr - yr_O < -180 ? yr - yr_O + 360 : yr - yr_O;
        }

        // z的计算过程
        let zr_f = zr + 360;
        let zr_Of = zr_O + 360;

        if (zr_f > zr_Of) {
            z = (zr_f - zr_Of > 180 ? zr_f - zr_Of - 360 : zr_f - zr_Of);
        } else {
            z = (zr_f - zr_Of < -180 ? zr_f - zr_Of + 360 : zr_f - zr_Of);
        }


        // x的计算过程
        let xr_f = xr + 360;
        let xr_Of = xr_O + 360;

        if (xr_f > xr_Of) {
            x = (xr_f - xr_Of > 180 ? xr_f - xr_Of - 360 : xr_f - xr_Of);
        } else {
            x = (xr_f - xr_Of < -180 ? xr_f - xr_Of + 360 : xr_f - xr_Of);
        }





        y = ((y / angle).toFixed(14) / 12).toFixed(14)
        z = ((z / angle).toFixed(14) / 12).toFixed(14)
        x = ((x / angle).toFixed(14) / 12).toFixed(14)





        let car_euler = new THREE.Euler(0, 0, -z, 'XYZ')
        let carBox_euler = new THREE.Euler(0, -y, 0, 'XYZ')
        let gltfBox_euler = new THREE.Euler(x, 0, 0, 'XYZ')

        let quaternion_car = new THREE.Quaternion().setFromEuler(car_euler);
        let quaternion_carBox = new THREE.Quaternion().setFromEuler(carBox_euler);
        let quaternion_gltfBox = new THREE.Quaternion().setFromEuler(gltfBox_euler);

        let index_Flag = 0;
        let a = setInterval(() => {
            if (index_Flag >= 11) {
                clearInterval(a)
            }
            car.applyQuaternion(quaternion_car);
            carBox.applyQuaternion(quaternion_carBox)
            gltfBox.applyQuaternion(quaternion_gltfBox)
            // scene.applyQuaternion(quaternion_carBox)

            index_Flag++
        }, 60)

    }


    zr_O = zr;
    xr_O = xr;
    yr_O = yr;
}