using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using K22CNT2_PhamThanhDat_2210900007_Project3.Models;

namespace K22CNT2_PhamThanhDat_2210900007_Project3.Controllers
{
    public class PTDQuanTrisController : Controller
    {
        private K22CNT2_PhamThanhDat_Project3Entities db = new K22CNT2_PhamThanhDat_Project3Entities();

        // GET: PTDQuanTris
        public ActionResult Index()
        {
            return View(db.PTDQuanTri.ToList());
        }

        // GET: PTDQuanTris/Details/5
        public ActionResult Details(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDQuanTri pTDQuanTri = db.PTDQuanTri.Find(id);
            if (pTDQuanTri == null)
            {
                return HttpNotFound();
            }
            return View(pTDQuanTri);
        }

        // GET: PTDQuanTris/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: PTDQuanTris/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "PTDTaikhoan,PTDTrangthai")] PTDQuanTri pTDQuanTri)
        {
            if (ModelState.IsValid)
            {
                db.PTDQuanTri.Add(pTDQuanTri);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(pTDQuanTri);
        }

        // GET: PTDQuanTris/Edit/5
        public ActionResult Edit(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDQuanTri pTDQuanTri = db.PTDQuanTri.Find(id);
            if (pTDQuanTri == null)
            {
                return HttpNotFound();
            }
            return View(pTDQuanTri);
        }

        // POST: PTDQuanTris/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "PTDTaikhoan,PTDTrangthai")] PTDQuanTri pTDQuanTri)
        {
            if (ModelState.IsValid)
            {
                db.Entry(pTDQuanTri).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(pTDQuanTri);
        }

        // GET: PTDQuanTris/Delete/5
        public ActionResult Delete(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDQuanTri pTDQuanTri = db.PTDQuanTri.Find(id);
            if (pTDQuanTri == null)
            {
                return HttpNotFound();
            }
            return View(pTDQuanTri);
        }

        // POST: PTDQuanTris/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string id)
        {
            PTDQuanTri pTDQuanTri = db.PTDQuanTri.Find(id);
            db.PTDQuanTri.Remove(pTDQuanTri);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
