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
    public class PTDBaoTrisController : Controller
    {
        private K22CNT2_PhamThanhDat_Project3Entities db = new K22CNT2_PhamThanhDat_Project3Entities();

        // GET: PTDBaoTris
        public ActionResult Index()
        {
            var pTDBaoTri = db.PTDBaoTri.Include(p => p.PTDTrangTB);
            return View(pTDBaoTri.ToList());
        }

        // GET: PTDBaoTris/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDBaoTri pTDBaoTri = db.PTDBaoTri.Find(id);
            if (pTDBaoTri == null)
            {
                return HttpNotFound();
            }
            return View(pTDBaoTri);
        }

        // GET: PTDBaoTris/Create
        public ActionResult Create()
        {
            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi");
            return View();
        }

        // POST: PTDBaoTris/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "PTDThietBiID,PTDNgayBaoTri,PTDMoTaBaoTri,PTDChiPhi,PTDNguoiThucHien")] PTDBaoTri pTDBaoTri)
        {
            if (ModelState.IsValid)
            {
                db.PTDBaoTri.Add(pTDBaoTri);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi", pTDBaoTri.PTDThietBiID);
            return View(pTDBaoTri);
        }

        // GET: PTDBaoTris/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDBaoTri pTDBaoTri = db.PTDBaoTri.Find(id);
            if (pTDBaoTri == null)
            {
                return HttpNotFound();
            }
            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi", pTDBaoTri.PTDThietBiID);
            return View(pTDBaoTri);
        }

        // POST: PTDBaoTris/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "PTDThietBiID,PTDNgayBaoTri,PTDMoTaBaoTri,PTDChiPhi,PTDNguoiThucHien")] PTDBaoTri pTDBaoTri)
        {
            if (ModelState.IsValid)
            {
                db.Entry(pTDBaoTri).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PTDThietBiID = new SelectList(db.PTDTrangTB, "ID", "PTDTenThietBi", pTDBaoTri.PTDThietBiID);
            return View(pTDBaoTri);
        }

        // GET: PTDBaoTris/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PTDBaoTri pTDBaoTri = db.PTDBaoTri.Find(id);
            if (pTDBaoTri == null)
            {
                return HttpNotFound();
            }
            return View(pTDBaoTri);
        }

        // POST: PTDBaoTris/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            PTDBaoTri pTDBaoTri = db.PTDBaoTri.Find(id);
            db.PTDBaoTri.Remove(pTDBaoTri);
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
