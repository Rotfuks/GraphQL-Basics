const customerResolver = require('./customer');
const productResolver = require('./product');
const wishlistResolver = require('./wishlist');

const nodeResolver = {
  Node: {
    __resolveType(node) {
      if (node.name) {
        return 'Product';
      } if(node.fullname) {
        return 'Customer';
      } if(node.title) {
        return 'Wishlist';
      }}}};

module.exports = [nodeResolver, customerResolver,
  productResolver, wishlistResolver];