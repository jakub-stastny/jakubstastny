import * as cherry_core from 'cherry-cljs/cljs.core.js';
import * as axios from 'axios';
var api_key = process.env.MAILER_LITE_API_TOKEN;
var group_id = "129574750637787099";
var headers = cherry_core.array_map("Content-Type", "application/json", "X-MailerLite-ApiKey", api_key);
var endpoint = "https://api.mailerlite.com/api/v2/subscribers";
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
return ({ "statusCode": status, "body": cherry_core.str.call(null, JSON.stringify(({ "message": body }), null, 2), "\n") });
});
var subscribe = (function (email) {
console.log(cherry_core.str.call(null, "Subscribing ", email, "."));
const data1 = cherry_core.array_map(cherry_core.keyword("email"), email, cherry_core.keyword("groups"), cherry_core.vector(group_id));
const options2 = cherry_core.array_map(cherry_core.keyword("headers"), headers);
console.log(data1);
console.log(options2);
return console.log("then").then(axios.post(endpoint, cherry_core.clj__GT_js.call(null, data1), cherry_core.clj__GT_js.call(null, options2)), (function (response) {
console.log("Subscription successful:", response.data);
return response.call(null, 200, cherry_core.str.call(null, response.data));
}), (function (error) {
console.error("Subscription failed:", _error.response);
response.call(null, response.error.status, response.error.data);
return response.call(null);
}));
});
var handle_post = (function (event, context) {
const vec__11 = parse_json.call(null, event.body);
const error2 = cherry_core.nth.call(null, vec__11, 0, null);
const data3 = cherry_core.nth.call(null, vec__11, 1, null);
console.log("handle-post", error2, cherry_core.clj__GT_js.call(null, data3));
if (cherry_core.truth_.call(null, error2)) {
return response.call(null, 400, cherry_core.ex_info.call(null, error2));} else {
if (cherry_core.truth_.call(null, cherry_core.contains_QMARK_.call(null, data3, cherry_core.keyword("email")))) {
return response.call(null, 200, subscribe.call(null, cherry_core.keyword("email").call(null, data3)));} else {
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
if (cherry_core.truth_.call(null, cherry_core._EQ_.call(null, method1, "POST"))) {
return handle_post.call(null, event, context);} else {
if (cherry_core.truth_.call(null, cherry_core._EQ_.call(null, method1, "HEAD"))) {
return response.call(null, 200, "");} else {
if (cherry_core.truth_.call(null, cherry_core.keyword("else"))) {
return response.call(null, 405, "Method not allowed");} else {
return null;}}}
}));
});

export { api_key, handler, dbg, group_id, parse_json, endpoint, response, handle_post, subscribe, headers }
