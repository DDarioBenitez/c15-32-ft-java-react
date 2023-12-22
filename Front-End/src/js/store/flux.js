const getState = ({ getStore, getActions, setStore }) => {
	return {
		store: {
			opalApi:[],
			fakeApi:[],
			men:[],
			woman:[],
			accesorios:[],
			sale: [
				{
					id: 1,
					img: 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
					nameProduct: 'Zapatos Nike',
					price: 80,
					quantity: 1,
				},
				{
					id: 2,
					img: 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1099&q=80',
					nameProduct: 'Reloj',
					price: 50,
					quantity: 1,
				},
				{
					id: 3,
					img: 'https://images.unsplash.com/photo-1546868871-7041f2a55e12?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80',
					nameProduct: 'Smartwatch',
					price: 90,
					quantity: 1,
				},
				{
					id: 4,
					img: 'https://images.unsplash.com/photo-1585386959984-a4155224a1ad?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80',
					nameProduct: 'Perfume',
					price: 50,
					quantity: 1,
				},
				{
					id: 5,
					img: 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
					nameProduct: 'Audifonos',
					price: 20,
					quantity: 1,
				},
				// Aquí pueden agregar más o modificar los productos existentes
			],
			newColeccion:[
				{
					id: 1,
					img: 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
					nameProduct: 'Zapatos Nike',
					price: 80,
					quantity: 1,
				},
				{
					id: 2,
					img: 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1099&q=80',
					nameProduct: 'Reloj',
					price: 50,
					quantity: 1,
				},
				{
					id: 3,
					img: 'https://images.unsplash.com/photo-1546868871-7041f2a55e12?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80',
					nameProduct: 'Smartwatch',
					price: 90,
					quantity: 1,
				},
				{
					id: 4,
					img: 'https://images.unsplash.com/photo-1585386959984-a4155224a1ad?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80',
					nameProduct: 'Perfume',
					price: 50,
					quantity: 1,
				},
				{
					id: 5,
					img: 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
					nameProduct: 'Audifonos',
					price: 20,
					quantity: 1,
				},
				// Aquí pueden agregar más o modificar los productos existentes
			],
			products:[],
			womansClothing: [],
			mensClothing: [],
			jewelery:[
		// 					{
        //         "id": 5,
        //         "title": "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
        //         "price": 695,
		//  		"old-price": 695,
        //         "description": "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
        //         "category": "jewelery",
        //         "image": "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
        //         "rating": {
        //             "rate": 4.6,
        //             "count": 400
        // }
				],
			carrito:[
				// {nombre:'',
				// imagen:'',
				// etc:''}
				],
			token: false, //poner token de OpalApi
			product: null,
				//ambiar titulo y poner logo en la ventana arriba , achicar el formulario de registro a un container//presentacion ess con link deployado y video es para formulario// crear fonod  para meet de presentacion dcon logo marca
		},
		actions: {
			//**************** http requests **********//
			getJewelery: async (url) => {
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
					setStore({ jewelery : data, fakeApi:[...store.fakeApi, data] });
					console.log(store.fakeApi);
					// setStore({ paginationPeople: data, peoplesCount: data.count });
					return true
				}
				catch (error) { console.log(error) };
			},
			getMensClothing: async (url) => {
				const store = getStore();
				try {
					const res = await fetch(url+"men's clothing", {
						method: 'GET',
						headers: {
							'Content-Type': 'application/json'
						}
					})
					const data = await res.json()
					console.log({ data });
					setStore({ mensClothing : data, fakeApi:[...store.fakeApi, data] });
					console.log(store.store.fakeApi);
					return true
				}
				catch (error) { console.log(error) };
			},
			getWomansClothing: async (url) => {
				const store = getStore();
				try {
					const res = await fetch(url+ "women's clothing", {
						method: 'GET',
						headers: {
							'Content-Type': 'application/json'
						}
					})
					const data = await res.json()
					console.log({ data });
					setStore({ womansClothing : data, fakeApi:[...store.fakeApi, data] });
					console.log(store.fakeApi);
					// setStore({ paginationPeople: data, peoplesCount: data.count });
					return true
				}
				catch (error) { console.log(error) };
			},
			getSale: async (url) => {
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
					setStore({ sale : data , opalApi: [...store.opalApi, data] });
					console.log(store.opalApi);
					return true
				}
				catch (error) { console.log(error) };
			},
			getNew: async (url) => {
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
					setStore({ new : data , opalApi: [...store.opalApi, data] });
					console.log(store.opalApi);
					return true
				}
				catch (error) { console.log(error) };
			},
			getMen: async (url) => {
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
					setStore({ men : data , opalApi: [...store.opalApi, data] });
					console.log(store.opalApi);
					return true
				}
				catch (error) { console.log(error) };
			},
			getWoman: async (url) => {
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
					setStore({ woman : data , opalApi: [...store.opalApi, data] });
					console.log(store.opalApi);
					return true
				}
				catch (error) { console.log(error) };
			},
			getAccesorios: async (url) => {
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
					setStore({ accesorios : data, opalApi: [...store.opalApi, data] });
					console.log(store.opalApi);
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
					setStore({ products : data, opalApi: [...store.opalApi, data] });
					console.log(store.opalApi);
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
			},//concatenar id en componente con params

			// ************ funciones *************** //
			modificarCantidad :(cantidad)=>{
				const store = getStore();
				let counter = 1
				
				counter = cantidad === '+' ? counter++ : counter > 1 ? counter-- : null
				
				console.log(counter);
				return counter
				// se usa en cards para aumentar la cantidad de productos
			}, //aumentar cantidad producto carrito
			addCarrito: (item) => {
				const store = getStore();
				const { id, nombre, precio, imagen, talle, color } = item;
			
				const productoEnCarrito = store.carrito.find((producto) => item.id === producto.id);
			
				if (productoEnCarrito) {
					// Si el producto ya está en el carrito, actualiza la cantidad
					const nuevoCarrito = store.carrito.map((producto) =>
						item.id === producto.id ? { ...producto, cantidad: producto.cantidad + 1 } : producto
					);
					setStore({ carrito: nuevoCarrito }); // Quita los corchetes extras
				} else {
					setStore({ carrito: [...store.carrito, { id, nombre, precio, imagen, cantidad: 1, talle, color }] });
				}
			
				console.log(store.carrito);
			},
			getProductById: (id)=>{
					const store = getStore();

					console.log(id, nombre);
					let foundProductFakeApi = store?.FakeApi?.find((item, i) => { item[i].id === id })
					let foundProductOpalApi = store?.opalApi?.find((item, i) => { item[i].id === id })
					
					console.log({ foundProduct });
					const data= foundProductFakeApi? ({...foundProductFakeApi}) : ({...foundProductOpalApi}) 
					setStore({ product: data })
			// busca el producto y lo setea para mostrar sus detalles.
			}, //detalles del producto vista
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
					return true
				}
				catch (error) { console.log(error) };
			} //id mercadopago

}}}

export default getState;
