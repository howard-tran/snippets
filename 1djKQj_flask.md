```python
from datetime import datetime
from sqlalchemy.orm import relationship
from app import db
from sqlalchemy import String, DateTime, Integer
from sqlalchemy.dialects.postgresql import UUID
from uuid import uuid4

class TestMigration(db.Model):
    __tablename__ = "test_migration"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid4())
    test_01 = db.Column(Integer, nullable=True)
    test_02 = db.Column(Integer, nullable=True)
```

```python
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///app.db'

# Or using config object
app.config.from_object(Config)

# Config file (config.py)
class Config(object):
    SQLALCHEMY_DATABASE_URI = f"postgresql://{os.environ.get('POSTGRES_USER')}:{os.environ.get('POSTGRES_PASSWORD')}@{os.environ.get('POSTGRES_HOST')}:{os.environ.get('POSTGRES_PORT')}/{os.environ.get('POSTGRES_DB')}"
```
```bash
flask db migrate --rev-id "$(date +%s%N | cut -b1-13)"
flask db upgrade # Will create the test_migration table in Database

# Fall back 3 versions
flask db downgrade
flask db downgrade
flask db downgrade

# Forward 3 versions
flask db upgrade
flask db upgrade
flask db upgrade
```
