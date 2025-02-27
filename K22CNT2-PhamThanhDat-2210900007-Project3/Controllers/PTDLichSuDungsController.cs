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
    public class PTDLichSuDungsController : Controller
    {
        private K22CNT2_PhamThanhDat_Project3Entities db = new K22CNT2_PhamThanhDat_Project3Entities();

        // GET: PTDLichSuDungs
        public ActionResult Index()
        {
            var pTDLichSuDung = db.PTDLichSuDung.Include(p => p.PTDNguoiDung).Include(p => p.PTDTrangTB);
            return View(pTDLichSuDung.ToList());
        }

        // GET: PTDLichSuDungs/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDLichSuDung pTDLichSuDung = db.PTDLichSuDung.Find(id);
            if (pTDLichSuDung == null)
            {
                return HttpNotFound();
            }
            return View(pTDLichSuDung);
        }

        // GET: PTDLichSuDungs/Create
        public ActionResult Create()
        {
            ViewBag.PTDNguoiDungID = new SelectList(db.PTDNguoiDung, "ID", "PTDTen");
            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi");
            return View();
        }

        // POST: PTDLichSuDungs/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,PTDThietBiID,PTDNguoiDungID,PTDNgaySuDung,PTDMucDichSuDung")] PTDLichSuDung pTDLichSuDung)
        {
            if (ModelState.IsValid)
            {
                db.PTDLichSuDung.Add(pTDLichSuDung);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.PTDNguoiDungID = new SelectList(db.PTDNguoiDung, "ID", "PTDTen", pTDLichSuDung.PTDNguoiDungID);
            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi", pTDLichSuDung.PTDThietBiID);
            return View(pTDLichSuDung);
        }

        // GET: PTDLichSuDungs/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDLichSuDung pTDLichSuDung = db.PTDLichSuDung.Find(id);
            if (pTDLichSuDung == null)
            {
                return HttpNotFound();
            }
            ViewBag.PTDNguoiDungID = new SelectList(db.PTDNguoiDung, "ID", "PTDTen", pTDLichSuDung.PTDNguoiDungID);
            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi", pTDLichSuDung.PTDThietBiID);
            return View(pTDLichSuDung);
        }

        // POST: PTDLichSuDungs/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,PTDThietBiID,PTDNguoiDungID,PTDNgaySuDung,PTDMucDichSuDung")] PTDLichSuDung pTDLichSuDung)
        {
            if (ModelState.IsValid)
            {
                db.Entry(pTDLichSuDung).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PTDNguoiDungID = new SelectList(db.PTDNguoiDung, "ID", "PTDTen", pTDLichSuDung.PTDNguoiDungID);
            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi", pTDLichSuDung.PTDThietBiID);
            return View(pTDLichSuDung);
        }

        // GET: PTDLichSuDungs/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDLichSuDung pTDLichSuDung = db.PTDLichSuDung.Find(id);
            if (pTDLichSuDung == null)
            {
                return HttpNotFound();
            }
            return View(pTDLichSuDung);
        }

        // POST: PTDLichSuDungs/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            PTDLichSuDung pTDLichSuDung = db.PTDLichSuDung.Find(id);
            db.PTDLichSuDung.Remove(pTDLichSuDung);
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
