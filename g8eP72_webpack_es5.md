### `webpack.config.js`

```js
module.exports = {
  target: ["web", "es5"],
  module: {
    rules: [
      {
        test: /\.ts?$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ['@babel/preset-typescript', '@babel/preset-env']
          }
        }
      },
      {
        test: /\.js?$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ['@babel/preset-env']
          }
        }
      },
    ],
  }
}
```

### `babel.config.json`

```json
{
  "presets": [
    "@babel/preset-typescript",
    "@babel/preset-env"
  ],
  "plugins": ["@babel/plugin-syntax-dynamic-import"]
}
```

### `package.json`

```json
"devDependencies": {
  "babel-loader": "8.3.0",
  "@babel/preset-env": "^7.24.8",
  "@babel/preset-typescript": "^7.24.7",
  "@babel/plugin-syntax-dynamic-import": "^7.8.3",
}
```
