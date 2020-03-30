import { gql } from 'apollo-server-express';

export default gql`
extend type Query {
  products(id: ID, search: String): [Product!]
}
type Product implements Node {
  id: ID!
  name: String!
}
input ProductInput {
  id: ID
  name: String
}
extend type Mutation {
  createProduct(name: String!): Product
  deleteProduct(id: ID!): Boolean
}
`;
