const { ApolloServer, gql } = require('apollo-server');

const schema = gql`
    type Query {
        product: Product
    }
    type Product {
        name: String!
    }
`;

const resolvers = {
  Query: {
    product: () => {
      return {
        name: 'Kartoffeln',
      };
    },
  },
};

const server = new ApolloServer({
  typeDefs: schema,
  resolvers,
});

// The `listen` method launches a web server.
server.listen().then(({ url }) => {
  console.log(`Server ready at ${url}`);
});