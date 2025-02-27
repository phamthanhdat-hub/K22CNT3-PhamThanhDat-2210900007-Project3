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
    public class PTDNguoiDungsController : Controller
    {
        private K22CNT2_PhamThanhDat_Project3Entities db = new K22CNT2_PhamThanhDat_Project3Entities();

        // GET: PTDNguoiDungs
        public ActionResult Index()
        {
            return View(db.PTDNguoiDung.ToList());
        }

        // GET: PTDNguoiDungs/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDNguoiDung pTDNguoiDung = db.PTDNguoiDung.Find(id);
            if (pTDNguoiDung == null)
            {
                return HttpNotFound();
            }
            return View(pTDNguoiDung);
        }

        // GET: PTDNguoiDungs/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: PTDNguoiDungs/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,PTDTen,PTDEmail,PTDVaiTro,PTDMatKhau")] PTDNguoiDung pTDNguoiDung)
        {
            if (ModelState.IsValid)
            {
                db.PTDNguoiDung.Add(pTDNguoiDung);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(pTDNguoiDung);
        }

        // GET: PTDNguoiDungs/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDNguoiDung pTDNguoiDung = db.PTDNguoiDung.Find(id);
            if (pTDNguoiDung == null)
            {
                return HttpNotFound();
            }
            return View(pTDNguoiDung);
        }

        // POST: PTDNguoiDungs/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,PTDTen,PTDEmail,PTDVaiTro,PTDMatKhau")] PTDNguoiDung pTDNguoiDung)
        {
            if (ModelState.IsValid)
            {
                db.Entry(pTDNguoiDung).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(pTDNguoiDung);
        }

        // GET: PTDNguoiDungs/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDNguoiDung pTDNguoiDung = db.PTDNguoiDung.Find(id);
            if (pTDNguoiDung == null)
            {
                return HttpNotFound();
            }
            return View(pTDNguoiDung);
        }

        // POST: PTDNguoiDungs/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            PTDNguoiDung pTDNguoiDung = db.PTDNguoiDung.Find(id);
            db.PTDNguoiDung.Remove(pTDNguoiDung);
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
