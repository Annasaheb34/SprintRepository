package com.onlineeyeclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


import com.onlineeyeclinic.dto.Report;
import com.onlineeyeclinic.dto.Spectacles;
import com.onlineeyeclinic.exceptions.ReportIdNotFoundException;


@Service
public interface IReportService {
	//method for creating a report
	public Report addReport(Report report);
	//method for updating a report
    public Report updateReport(Report report);
  //method for deleting a report
    public Report removeReport(int reportId)throws ReportIdNotFoundException;
  //method for viewing report by individual id
    public Report viewReport(int reportId)throws ReportIdNotFoundException;
  //method for viewing the report by date
    public List<Report> viewReportsByDate(Date date);
    //viewing all spectacles
    public List<Spectacles> viewSpectacles();
}
