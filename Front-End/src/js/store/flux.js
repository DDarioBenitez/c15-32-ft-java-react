const getState = ({ getStore, getActions, setStore }) => {
	return {
		store: {
			jewerly: ['1','2'],
			womansClothing: ['3','4'],
			mensClothing: ['6','7'],
			jewerly:[],
			products: [],
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
			changeColor: (index, color) => {
				//get the store
				const store = getStore();

				//we have to loop the entire demo array to look for the respective index
				//and change its color
				const demo = store.demo.map((elm, i) => {
					if (i === index) elm.background = color;
					return elm;
				});

				//reset the global store
				setStore({ demo: demo });
			}
		}
	};
};

export default getState;
