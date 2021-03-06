const { gql } = require('apollo-server');

const customerSchema = require('./customer');
const wishlistSchema = require('./wishlist');
const productSchema = require('./product');

const linkSchema = gql`
  type Query {
    _: Boolean
  }
  interface Node {
    id: ID!
  }
`;
module.exports = [linkSchema, customerSchema,
  wishlistSchema, productSchema];