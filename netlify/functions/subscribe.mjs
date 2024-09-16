import * as cherry_core from 'cherry-cljs/cljs.core.js';
var parse_json = (function (body) {
return (() => {
try{
return cherry_core.vector(null, cherry_core.js__GT_clj.call(null, JSON.parse(body), cherry_core.keyword("keywordize-keys"), true));}
catch(error1){
console.log("ERROR", error1);
return cherry_core.vector(error1, null);}

})();
});
var response = (function (status, body) {
return ({ "statusCode": status, "body": JSON.stringify(({ "message": body }), null, 2) });
});
var handle_post = (function (event, context) {
const vec__11 = parse_json.call(null, event.body);
const error2 = cherry_core.nth.call(null, vec__11, 0, null);
const data3 = cherry_core.nth.call(null, vec__11, 1, null);
console.log("handle-post", error2, cherry_core.clj__GT_js.call(null, data3));
if (cherry_core.truth_.call(null, error2)) {
return response.call(null, 400, cherry_core.ex_info.call(null, error2));} else {
if (cherry_core.truth_.call(null, cherry_core.contains_QMARK_.call(null, data3, cherry_core.keyword("email")))) {
return response.call(null, 200, "OK");} else {
if (cherry_core.truth_.call(null, cherry_core.keyword("else"))) {
return response.call(null, 400, "Validation error: key 'email' is missing.");} else {
return null;}}}
});
var dbg = (function (event, context, fun) {
const result1 = fun.call(null, event, context);
console.log("Response", result1);
return result1;
});
var handler = (async function (event, context) {
console.log("handler");
return dbg.call(null, event, context, (function (event, context) {
const method1 = event.httpMethod;
console.log("HTTP method", method1);
if (cherry_core.truth_.call(null, cherry_core._EQ_.call(null, method1, "POST"))) {
return handle_post.call(null, event, context);} else {
if (cherry_core.truth_.call(null, cherry_core._EQ_.call(null, method1, "HEAD"))) {
return response.call(null, 200, "");} else {
if (cherry_core.truth_.call(null, cherry_core.keyword("else"))) {
return response.call(null, 405, "Method not allowed");} else {
return null;}}}
}));
});

export { parse_json, response, handle_post, dbg, handler }
