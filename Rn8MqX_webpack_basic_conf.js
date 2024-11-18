const path = require("path");
const fs = require("fs");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const appDirectory = fs.realpathSync(process.cwd());

module.exports = {
  entry: {
    "bundleName": path.resolve(appDirectory, "src/main.ts"),
    "bundleName01": path.resolve(appDirectory, "src/account.ts"),
    "bundleName02": path.resolve(appDirectory, "src/leaderboard.ts")
  },
  output: {
    filename: "[name].js",
    path: path.resolve(appDirectory, 'public/dist'),
  },
  devtool: "eval-source-map",
  // devtool: "none",
  // this is necessary to use both typescript and javascript
  resolve: {
    extensions: [".tsx", ".ts", ".js"],
  },
  // we can use live-server to replace this one
  devServer: {
    host: "localhost",
    port: 8082, // port that we're using for local host (localhost:8080)
    contentBase: path.resolve(appDirectory, "public"), // tells webpack to serve from this
    publicPath: "/",
    hot: true,
  },
  watchOptions: {
    aggregateTimeout: 200,
    poll: true,
    ignored: ['**/css', '**/node_modules'],
  },
  module: {
    rules: [
      {
        test: /\.css?$/,
        use: "css-loader",
        exclude: /node_modules/,
      },
      {
        test: /\.ts?$/,
        use: "ts-loader",
        exclude: /node_modules/,
      },
    ],
  },
  mode: "development",
};
