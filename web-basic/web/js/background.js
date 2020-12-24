// export let point = new THREE.PointLight(0x444444,2);
export let point = new THREE.Object3D()
// let point1 =  new THREE.PointLight(0x444444);
// let point2 =  new THREE.PointLight(0x444444);
// let point3 =  new THREE.PointLight(0x444444);
// let point4 =  new THREE.PointLight(0x444444);
// let point5 =  new THREE.PointLight(0x444444);
// point1.position.set(0, 10000, 0); //点光源位置
// point2.position.set(10000,0 , 0); //点光源位置
// point3.position.set(-10000,0 , 0); //点光源位置
// point4.position.set(0,0,10000); //点光源位置
// point5.position.set(0,-10000,0); //点光源位置
// point.add(point1)
// point.add(point2)
// point.add(point3)
// point.add(point4)
// point.add(point5)

// let point1 =  new THREE.PointLight(0x63d5ff);
// let point2 =  new THREE.PointLight(0x63d5ff);
// let point3 =  new THREE.PointLight(0x63d5ff);
// let point4 =  new THREE.PointLight(0x63d5ff);
// let point5 =  new THREE.PointLight(0x63d5ff);
// point1.position.set(0, 10000, 0); //点光源位置
// point2.position.set(10000,0 , 0); //点光源位置
// point3.position.set(-10000,0 , 0); //点光源位置
// point4.position.set(0,0,10000); //点光源位置
// point5.position.set(0,-10000,0); //点光源位置
// point.add(point1)
// point.add(point2)
// point.add(point3)
// point.add(point4)
// point.add(point5)

var directionalLight = new THREE.DirectionalLight( 0xffffff );
directionalLight.position.set( 0, 500, 0).normalize();
point.add(directionalLight)

//环境光
export let ambient = new THREE.Object3D() 
// export let ambient = new THREE.AmbientLight(0x444444);
