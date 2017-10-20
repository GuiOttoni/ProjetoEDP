using RestSharp;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace Edp.Api.Command.Util
{
    public class RestExecutor
    {

        public async System.Threading.Tasks.Task<string> ExecuteAsync(
            List<Parameter> parametros,
            string URI,
            Method _method,
            string token,
            string contentType)
        {
            RestResponse response = new RestResponse();
            RestClient restClient = new RestClient(URI);

            RestRequest request = new RestRequest(_method);
            request.AddHeader("cache-control", "no-cache");
            request.AddHeader("content-type", contentType);
            request.AddHeader("Authorization", token);
            foreach (Parameter p in parametros)
            {
                request.AddParameter(p);
            }

            TaskCompletionSource<IRestResponse> taskCompletion = new TaskCompletionSource<IRestResponse>();

            RestRequestAsyncHandle handle = restClient.ExecuteAsync(
                request, r => taskCompletion.SetResult(r));

            response = (RestResponse)(await taskCompletion.Task);
            return response.Content;
        }
    }
}
