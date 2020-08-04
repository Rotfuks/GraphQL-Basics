const { gql } = require('apollo-server');

module.exports = gql`
extend type Query {
  products(id: ID, search: String): [Product!]
}
type Product implements Node {
  id: ID!
  name: String!
}
`;
