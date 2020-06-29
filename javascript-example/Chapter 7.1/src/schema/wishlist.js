const { gql } = require('apollo-server');

module.exports = gql`
type Wishlist implements Node {
  id: ID!
  title: String
  products: [Product]!
}
`;
