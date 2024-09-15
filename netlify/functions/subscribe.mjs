import * as cherry_core from 'cherry-cljs/cljs.core.js';
var handler = (function (event, context) {
return Promise.resolve(({ "statusCode": 200, "body": "Hello, World!" }));
});

export { handler }
