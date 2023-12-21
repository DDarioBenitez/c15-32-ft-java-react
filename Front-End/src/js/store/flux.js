const getState = ({ getStore, getActions, setStore }) => {
	return {
		store: {
			womansClothing: [],
			mensClothing: [],
			jewerly:[
						// 	{
        //         "id": 5,
        //         "title": "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
        //         "price": 695,
        //         "description": "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
        //         "category": "jewelery",
        //         "image": "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
        //         "rating": {
        //             "rate": 4.6,
        //             "count": 400
        // }

			],
			products: [],
			token: false,
			seePassword: true,
			carrito:[
				// {nombre:'',
				// imagen:'',
				// etc:''}
				],
			product: null
				
				//ambiar titulo y poner logo en la ventana arriba , achicar el formulario de registro a un container//presentacion ess con link deployado y video es para formulario// crear fonod  para meet de presentacion dcon logo marca
		},
		actions: {
			// Use getActions to call a function within a fuction
			exampleFunction: () => {
				getActions().changeColor(0, "green");
			},
			loadSomeData: () => {
				/**
					fetch().then().then(data => setStore({ "foo": data.bar }))
				*/
			},
			getJewerly: async (url) => {
				const store = getStore();
				try {
					const res = await fetch(url, {
						method: 'GET',
						headers: {
							'Content-Type': 'application/json'
						}
					})
					const data = await res.json()
					console.log({ data });
					setStore({ jewerly : data });
					// setStore({ paginationPeople: data, peoplesCount: data.count });
					return true
				}
				catch (error) { console.log(error) };
			},
			getProducts: async (url) => {
				const store = getStore();
				try {
					const res = await fetch(url, {
						method: 'GET',
						headers: {
							'Content-Type': 'application/json'
						}
					})
					const data = await res.json()
					console.log({ data });
					setStore({ products : data });
					// setStore({ paginationPeople: data, peoplesCount: data.count });
					return true
				}
				catch (error) { console.log(error) };
			},

			getOneProduct: async (url, id) => {
				const store = getStore();
				try {
					const res = await fetch(url+id, {
						method: 'GET',
						headers: {
							'Content-Type': 'application/json'
						}
					})
					const data = await res.json()
					console.log({ data });
					setStore({ OneProduct : data });
					return true
				}
				catch (error) { console.log(error) };
			},



			prodCantidad :(cantidad, producto)=>{
				const store = getStore();
				let counter = 0
				let aumentar = counter++
				const item= {...item, cantidad: aumentar}
				setStore({carrito : [...store.carrito, item]})
				console.log(store.carrito, {aumentar});
			},
			addCarrito : (item)=>{
				const store = getStore();
				const{nombre, imagen, precio}=item
				let found = store.carrito.find((prod) => prod.imagen === imagen)
				if (found) return;
				setStore({carrito : [...store.carrito, {nombre, imagen, precio, cantidad : 1}]})
				console.log(store.carrito);
			},
			getProductById: (id, nombre)=>{
					const store = getStore();

					console.log(id, nombre);
					let foundProduct = store?.products?.find((product) => {product.nombre === nombre && product.id === id})
					console.log({ foundProduct });
					const data= ({...foundProduct})
					setStore({ product: data })
			}, 
			getPreference: async()=>{
				const store = getStore();
				try {
					const res = await fetch('http://opal.sa-east-1.elasticbeanstalk.com/api/transaccion/checkout', {
						method: 'GET',
						headers: {
							'Content-Type': 'application/json'
						},
						body: { 'detalles': [{ cantdidad: 1, precioTotal : 1, productId : 1 }]
						}
					})
					const data = await res.json()
					console.log({ data });// recibe un id para la compra en mercadopago
					setStore({ idMercadopago : data });//por si acaso se peude guardar  ono
					// setStore({ paginationPeople: data, peoplesCount: data.count });
					return true
				}
				catch (error) { console.log(error) };
			}
}}}

export default getState;
