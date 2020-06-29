const { gql } = require('apollo-server');

module.exports = gql`
extend type Query {
  customer(id: ID!): Customer
}
type Customer implements Node{
  id: ID!
  fullname: String!
  wishlists: [Wishlist]
}
`;
