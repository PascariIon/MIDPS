//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "Unit1.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma link "CSPIN"
#pragma resource "*.dfm"
#include "dos.h"
#include <stdio.h>

struct date d;
struct time t;

unsigned int seconds = 0;
unsigned int minutes = 0;
unsigned int hours = 0;

TForm1 *Form1;
//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
        : TForm(Owner)
{
}
//---------------------------------------------------------------------------


void __fastcall TForm1::FormActivate(TObject *Sender)
{
        char buf[20];
        char buf2[30];
        sprintf(buf," 00 hr 00 min 00 sec");
        sprintf(buf2," 00-00-0000 00:00:00");
        Timer->Text=(AnsiString)buf;
        CurrentTime->Text=(AnsiString)buf2;
        Timer1->Interval=1000;


}
//---------------------------------------------------------------------------
void __fastcall TForm1::Timer1Timer(TObject *Sender)
{
        char buf[20];
        getdate(&d);
        gettime(&t);
        sprintf(buf," %02d-%02d-%4d %02d:%02d:%02d",d.da_day,d.da_mon,d.da_year,
        t.ti_hour,t.ti_min,t.ti_sec);
        CurrentTime->Text=(AnsiString)buf;

}
//---------------------------------------------------------------------------
void __fastcall TForm1::Timer2Timer(TObject *Sender)
{
        char buf[20];
        seconds++;
        if(seconds == 60){
        minutes++;
        seconds = 0;
        }
        if(minutes == 60){
        hours++;
        minutes = 0;
        }
        if(hours == 24){
        hours = 0;
        seconds = 0;
        minutes = 0;
        }

        sprintf(buf," %02d hr %02d min %02d sec", hours, minutes, seconds);
        Timer->Text=(AnsiString)buf;

}
//---------------------------------------------------------------------------
void __fastcall TForm1::STARTClick(TObject *Sender)
{
        Timer2->Enabled = true;
        START->Enabled = false;
        RESET->Enabled = false;      
}
//---------------------------------------------------------------------------
void __fastcall TForm1::STOPClick(TObject *Sender)
{
        Timer2->Enabled = False;
        START->Enabled = true;
        RESET->Enabled = true;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::RESETClick(TObject *Sender)
{
        char buf[20];
        hours = 0;
        minutes = 0;
        seconds = 0;
        sprintf(buf," %02d hr %02d min %02d sec", hours, minutes, seconds);
        Timer->Text=(AnsiString)buf;
}
//---------------------------------------------------------------------------
void __fastcall TForm1::EXITClick(TObject *Sender)
{
        Form1->Close();
}
//---------------------------------------------------------------------------

