using System.Web;
using System.Web.Mvc;

namespace K22CNT2_PhamThanhDat_2210900007_Project3
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
