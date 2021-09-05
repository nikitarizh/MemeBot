# MEME BOT
> *wow, it sends memes*
***
## What is it?
Basically one of thousands telegram bots, but it's mine
***
## How to use?
Basically the latest version is available at https://t.me/alldayMemeBot  
***
## Self-hosting
But if you want to self-host it for some reason, here's how to do it:

1. Download latest release from Releases tab
2. Launch a MySQL database instance
3. Launch with env variables:
   - `BOT_TOKEN` - token obtained from *BotFather*
   - `DB_HOST` - host of database (e.g. *localhost* for a local db)
   - `DB_PORT` - port for a database (usually *3306* by default)
   - `DB_NAME` - name of a MySQL database
   - `DB_USERNAME` - username with **privileges** to **read/write data** to tables and **modify database structure**
   - `DB_PASSWORD` - password for the user with specified `DB_USERNAME`
4. Enjoy!