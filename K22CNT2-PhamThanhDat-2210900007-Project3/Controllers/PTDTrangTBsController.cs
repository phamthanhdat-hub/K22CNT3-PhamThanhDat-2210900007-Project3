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
    public class PTDTrangTBsController : Controller
    {
        private K22CNT2_PhamThanhDat_Project3Entities db = new K22CNT2_PhamThanhDat_Project3Entities();

        // GET: PTDTrangTBs
        public ActionResult Index()
        {
            var pTDTrangTB = db.PTDTrangTB.Include(p => p.PTDBaoTri);
            return View(pTDTrangTB.ToList());
        }

        // GET: PTDTrangTBs/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDTrangTB pTDTrangTB = db.PTDTrangTB.Find(id);
            if (pTDTrangTB == null)
            {
                return HttpNotFound();
            }
            return View(pTDTrangTB);
        }

        // GET: PTDTrangTBs/Create
        public ActionResult Create()
        {
            ViewBag.ID = new SelectList(db.PTDBaoTri, "PTDThietBiID", "PTDMoTaBaoTri");
            return View();
        }

        // POST: PTDTrangTBs/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,PTDTenThietBi,PTDAnh,PTDMoTa,PTDSoLuong,PTDTinhTrang,PTDNgayBaoTriTiepTheo")] PTDTrangTB pTDTrangTB)
        {
            if (ModelState.IsValid)
            {
                db.PTDTrangTB.Add(pTDTrangTB);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.ID = new SelectList(db.PTDBaoTri, "PTDThietBiID", "PTDMoTaBaoTri", pTDTrangTB.ID);
            return View(pTDTrangTB);
        }

        // GET: PTDTrangTBs/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDTrangTB pTDTrangTB = db.PTDTrangTB.Find(id);
            if (pTDTrangTB == null)
            {
                return HttpNotFound();
            }
            ViewBag.ID = new SelectList(db.PTDBaoTri, "PTDThietBiID", "PTDMoTaBaoTri", pTDTrangTB.ID);
            return View(pTDTrangTB);
        }

        // POST: PTDTrangTBs/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,PTDTenThietBi,PTDAnh,PTDMoTa,PTDSoLuong,PTDTinhTrang,PTDNgayBaoTriTiepTheo")] PTDTrangTB pTDTrangTB)
        {
            if (ModelState.IsValid)
            {
                db.Entry(pTDTrangTB).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ID = new SelectList(db.PTDBaoTri, "PTDThietBiID", "PTDMoTaBaoTri", pTDTrangTB.ID);
            return View(pTDTrangTB);
        }

        // GET: PTDTrangTBs/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDTrangTB pTDTrangTB = db.PTDTrangTB.Find(id);
            if (pTDTrangTB == null)
            {
                return HttpNotFound();
            }
            return View(pTDTrangTB);
        }

        // POST: PTDTrangTBs/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            PTDTrangTB pTDTrangTB = db.PTDTrangTB.Find(id);
            db.PTDTrangTB.Remove(pTDTrangTB);
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
