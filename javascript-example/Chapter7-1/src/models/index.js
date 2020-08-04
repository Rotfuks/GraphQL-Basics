let productdata = [
  {
    id: "2",
    name: 'Kartoffeln',
  }, {
    id: "3",
    name: 'Pasta',
  },];

let customerdata = [{
  id: 1,
  firstname: "Luke",
  lastname: "Skywalker",
  wishlistIds: ["10", "11"],
}];

let wishlistdata = [{
  id: "10",
  title: "Daily Needs",
  products: productdata,
}, {
  id: "11",
  title: "That one Recipe",
  products: [{
    id: "3",
    name: 'Pasta',
  }],
}];

module.exports = {
  productdata,
  customerdata,
  wishlistdata
};