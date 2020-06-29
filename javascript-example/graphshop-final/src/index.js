const { ApolloServer } = require('apollo-server');

const schema = require('./schema');
const resolvers = require('./resolvers');
const models = require('./models');

const server = new ApolloServer({
  typeDefs: schema,
  resolvers,
  context: {
    models,
  }
});

// The `listen` method launches a web server.
server.listen().then(({ url }) => {
  console.log(`Server ready at ${url}`);
});